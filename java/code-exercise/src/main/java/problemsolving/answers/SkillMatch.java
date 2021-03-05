package problemsolving.answers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class SkillMatch {

    private static final Set<MatchResult> mem = new HashSet<>();
    private static final Map<MatchResult, Boolean> alreadyWritten = new HashMap();
    private static int totalRecords = 0;
    private final Map<String, Set<String>> demandMap;
    private final Map<String, Set<String>> supplyMap;
    private final Set<MatchResult> matchResults;
    private final String supplyInputFilePath;
    private final String supplyInputFileName;
    private final String demandInputFilePath;
    private final String demandInputFileName;
    private final String matchMetricsFilePath;
    private final String matchMetricsFileName;
    private Map<String, Supply> skillToSupplyMap;
    private Map<String, Demand> skillToDemadMap;
    private List<Demand> demands;
    private List<Supply> supplies;

    public SkillMatch() {
        System.out.println("Initializing system...");
        supplyInputFilePath = "D:\\Java\\Java Files";
        supplyInputFileName = "New_Supply.csv";
        demandInputFilePath = "D:\\Java\\Java Files";
        demandInputFileName = "New_Demand.csv";
        matchMetricsFilePath = "D:\\Java\\Java Files";
        matchMetricsFileName = "DesiredOutput.csv";

        demandMap = new HashMap<>();
        supplyMap = new HashMap<>();
        matchResults = new HashSet<>();
        System.out.println("Initializing system complete.");
    }

    public static void main(String[] args) {
        System.out.println("Starting the Supply-Demand allocation.");
        SkillMatch sm = new SkillMatch();
        sm.readDemand();
        sm.readSupply();
        sm.prepareMatchMetrics();
        System.out.println("Finished the Supply-Demand allocation.");
        System.out.println("Total Records = " + totalRecords);
    }

    private void readDemand() {
        System.out.println("Reading demand...");
        try {
            skillToDemadMap = readDemandInputFile(demandInputFilePath, demandInputFileName);
            Set<String> demandIds = skillToDemadMap.keySet();
            for (String demandId : demandIds) {
                Set<String> skills = skillToDemadMap.get(demandId).skillSet;
                for (String s : skills) {
                    if (demandMap.containsKey(s)) {
                        demandMap.get(s).add(demandId);
                    } else {
                        Set<String> d = new HashSet<>();
                        d.add(demandId);
                        demandMap.put(s, d);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR WHILE READING DEMAND DATA.");
            e.printStackTrace();
        }
        System.out.println("Reading Demand finished.");
    }

    private void readSupply() {
        System.out.println("Reading Supply...");
        try {
            skillToSupplyMap = readSupplyInputFile(supplyInputFilePath, supplyInputFileName);
            Set<String> requirementIds = skillToSupplyMap.keySet();
            for (String reqId : requirementIds) {
                Set<String> skills = skillToSupplyMap.get(reqId).skillSet;
                for (String s : skills) {
                    if (supplyMap.containsKey(s)) {
                        supplyMap.get(s).add(reqId);
                    } else {
                        Set<String> d = new HashSet<>();
                        d.add(reqId);
                        supplyMap.put(s, d);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR WHILE READING SUPPLY DATA.");
            e.printStackTrace();
        }
        System.out.println("Reading Supply finished.");
    }

    private void prepareMatchMetrics() {
        System.out.println("Preparing Supply-Demand match Metrics ...");
        long started = Calendar.getInstance().getTimeInMillis();
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(matchMetricsFilePath + "\\" + matchMetricsFileName, false);
            fos.write(
                    "Demand id, SkillsInDemand, Associate id, Skills Supplied, Supply Grade, Demand Grade, Skill Matching Percentage, Matching Grade, Overall Match Percentage, Skills Matched\n"
                            .getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        int i = 0;

        try {
            for (String skillInDemand : demandMap.keySet()) {

                if (supplyMap.containsKey(skillInDemand)) {
                    Set<String> resources = supplyMap.get(skillInDemand);
                    Set<String> requirements = demandMap.get(skillInDemand);

                    Set<MatchResult> m =
                            prepareMetrics(skillInDemand, resources, requirements, fos);

                    i++;
                    if (i > 100) {
                        System.out.println("Work in progress... Please wait...Time elapsed = "
                                + (Calendar.getInstance().getTimeInMillis() - started) / 1000
                                + " secs");
                        i = 0;
                    }
                }
            }
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        System.out.println("Preparing Supply-Demand match Metrics finished. Total Time taken = "
                + (Calendar.getInstance().getTimeInMillis() - started) / 1000 + " secs");
    }

    private Set<MatchResult> prepareMetrics(String skillInDemand, Set<String> resources,
                                            Set<String> requirements, FileOutputStream fos) {
        Set<MatchResult> s = null;
        for (String reqId : requirements) {
            int i = 0;
            MatchResult[] m = new MatchResult[20];
            s = new HashSet<>();

            for (String resrcId : resources) {
                MatchResult mtch = new MatchResult();
                mtch.setDemandId(reqId);
                mtch.setSupplyId(resrcId);
                mtch.setDemandSkills(skillToDemadMap.get(reqId).skillSet);
                mtch.setSupplySkills(skillToSupplyMap.get(resrcId).skillSet);

                if (mem.contains(mtch) || i > 19)
                    break;

                Set<String> matchingSkills = findMatchingSubset(reqId, resrcId);
                double matchingGrade = findMatchingGrade(skillToDemadMap.get(reqId).rank,
                        skillToSupplyMap.get(resrcId).rank);
                mtch.setMatchPercentage((Double.valueOf(matchingSkills.size())
                        / Double.valueOf(skillToDemadMap.get(reqId).skillSet.size())) * 100);
                mtch.setMatchingSkills(matchingSkills);
                mtch.setMatchingGradePercentage((matchingGrade * mtch.getMatchPercentage()) / 100);
                mtch.setDemandGrade(skillToDemadMap.get(reqId).rank.name());
                mtch.setSupplyGrade(skillToSupplyMap.get(resrcId).rank.name());
                mtch.setMatchingGrade(skillToSupplyMap.get(resrcId).rank.name());
                mem.add(mtch);
                m[i++] = mtch;

                try {
                    for (MatchResult mr : m) {
                        if (mr != null) {
                            if (alreadyWritten.containsKey(mr))
                                continue;
                            alreadyWritten.put(mr, true);
                            totalRecords++;
                            String sb = mr.toString() + "\n";
                            fos.write(sb.getBytes());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }

    private double findMatchingGrade(Grade_Rank demandRank, Grade_Rank supplyRank) {
        if (supplyRank.getRank() == Grade_Rank.NA.getRank()) {
            return 0;
        }
        if (supplyRank.rank - demandRank.rank == 0) {
            return 100;
        }
        if (supplyRank.rank - demandRank.rank == -1) {
            return 70;
        }
        if (supplyRank.rank - demandRank.rank == 1) {
            return 100;
        }

        return 0;
        // return supplyRank.getRank() == Grade_Rank.NA.getRank() ? 0 : (supplyRank.rank
        // - demandRank.rank == 0) ? 100 : 70;
    }

    private Set<String> findMatchingSubset(String reqId, String resrcId) {
        Set<String> matchingSkills = new HashSet<>();
        for (String req : skillToDemadMap.get(reqId).skillSet) {
            for (String res : skillToSupplyMap.get(resrcId).skillSet) {
                if (req.equals(res)) {
                    matchingSkills.add(res);
                }
            }
        }
        return matchingSkills;
    }

    private void writeResultsToFile(String strb, String filePath, String fileName, boolean close)
            throws Exception {
        FileOutputStream fos = new FileOutputStream(filePath + "\\" + fileName, true);
        fos.write(strb.getBytes());
        if (close)
            if (fos != null) {
                fos.close();
            }
    }

    private Map<String, Demand> readDemandInputFile(String filePath, String fileName)
            throws Exception {
        System.out.println("Reading input file - " + filePath + "\\" + fileName);
        FileInputStream fis = new FileInputStream(filePath + "\\" + fileName);
        Scanner fileScnr = new Scanner(fis);
        Map<String, Set<String>> inputData = new HashMap<>();
        Map<String, Demand> inputDemands = new HashMap<>();
        boolean headerLine = true;
        while (fileScnr.hasNext()) {
            String nxtLine = fileScnr.nextLine();
            if (headerLine) {
                headerLine = false;
                continue;
            }
            if (nxtLine != null && !nxtLine.isEmpty()) {
                String[] row = nxtLine.split(",");
                if (row.length > 0 && row[0] != null && !(row[0].equals(""))) {
                    if (row.length > 2) {
                        Demand d = new Demand();
                        String resourceId = row[0].trim();
                        d.id = resourceId;

                        String rank = row[1].trim();
                        d.rank = Grade_Rank.getGrade(rank);
                        Set<String> skillSet = new HashSet<>();

                        for (int i = 2; i < row.length; i++) {
                            if (row[i] != null && !(row[i].equals(""))) {
                                String skills = row[i].trim().replaceAll("\"", "");
                                skillSet.add(skills);
                            }
                        }

                        d.skillSet = skillSet;

                        inputData.put(resourceId, skillSet);
                        inputDemands.put(resourceId, d);
                    }
                }
            }
        }
        if (fileScnr != null) {
            fileScnr.close();
        }
        if (fis != null) {
            fis.close();
        }
        return inputDemands;
    }

    private Map<String, Supply> readSupplyInputFile(String filePath, String fileName)
            throws Exception {
        System.out.println("Reading input file - " + filePath + "\\" + fileName);
        FileInputStream fis = new FileInputStream(filePath + "\\" + fileName);
        Scanner fileScnr = new Scanner(fis);
        Map<String, Set<String>> inputData = new HashMap<>();
        Map<String, Supply> inputSupplies = new HashMap<>();
        boolean headerLine = true;
        while (fileScnr.hasNext()) {
            String nxtLine = fileScnr.nextLine();
            if (headerLine) {
                headerLine = false;
                continue;
            }
            if (nxtLine != null && !nxtLine.isEmpty()) {
                String[] row = nxtLine.split(",");
                if (row.length > 0 && row[0] != null && !(row[0].equals(""))) {
                    if (row.length > 2) {
                        Supply s = new Supply();
                        String resourceId = row[0].trim();
                        s.id = resourceId;

                        String rank = row[1].trim();
                        s.rank = Grade_Rank.getGrade(rank);
                        Set<String> skillSet = new HashSet<>();

                        for (int i = 2; i < row.length; i++) {
                            if (row[i] != null && !(row[i].equals(""))) {
                                String skills = row[i].trim().replaceAll("\"", "");
                                skillSet.add(skills);
                            }
                        }

                        s.skillSet = skillSet;

                        inputData.put(resourceId, skillSet);
                        inputSupplies.put(resourceId, s);
                    }
                }
            }
        }
        if (fileScnr != null) {
            fileScnr.close();
        }
        if (fis != null) {
            fis.close();
        }
        return inputSupplies;
    }

    private enum Grade_Rank {
        PAT(0), PT(0), PA(1), P(1), A(2), SA(3), M(4), SM(5), AD(6), D(7), SD(8), NA(-1);

        private final int rank;

        Grade_Rank(int i) {
            this.rank = i;
        }

        public static Grade_Rank getGrade(String s) {
            for (Grade_Rank g : Grade_Rank.values()) {
                if (g.name().equalsIgnoreCase(s)) {
                    return g;
                }
            }
            return Grade_Rank.NA;
        }

        public int getRank() {
            return rank;
        }
    }

    private class MatchResult {
        private String demandId;
        private Set<String> demandSkills;
        private String supplyId;
        private Set<String> supplySkills;
        private double matchPercentage;
        private Set<String> matchingSkills;
        private double matchingGradePercentage;
        private String supplyGrade;
        private String demandGrade;
        private String matchingGrade;

        public String getDemandId() {
            return demandId;
        }

        public void setDemandId(String demandId) {
            this.demandId = demandId;
        }

        public Set<String> getDemandSkills() {
            return demandSkills;
        }

        public void setDemandSkills(Set<String> demandSkills) {
            this.demandSkills = demandSkills;
        }

        public String getSupplyId() {
            return supplyId;
        }

        public void setSupplyId(String supplyId) {
            this.supplyId = supplyId;
        }

        public Set<String> getSupplySkills() {
            return supplySkills;
        }

        public void setSupplySkills(Set<String> supplySkills) {
            this.supplySkills = supplySkills;
        }

        public double getMatchPercentage() {
            return matchPercentage;
        }

        public void setMatchPercentage(double matchPercentage) {
            this.matchPercentage = matchPercentage;
        }

        public Set<String> getMatchingSkills() {
            return matchingSkills;
        }

        public void setMatchingSkills(Set<String> matchingSkills) {
            this.matchingSkills = matchingSkills;
        }

        public double getMatchingGradePercentage() {
            return matchingGradePercentage;
        }

        public void setMatchingGradePercentage(double matchingGradePercentage) {
            this.matchingGradePercentage = matchingGradePercentage;
        }

        public String getSupplyGrade() {
            return supplyGrade;
        }

        public void setSupplyGrade(String supplyGrade) {
            this.supplyGrade = supplyGrade;
        }

        public String getDemandGrade() {
            return demandGrade;
        }

        public void setDemandGrade(String demandGrade) {
            this.demandGrade = demandGrade;
        }

        public String getMatchingGrade() {
            return matchingGrade;
        }

        public void setMatchingGrade(String matchingGrade) {
            this.matchingGrade = matchingGrade;
        }

        @Override
        public String toString() {
            return this.demandId + "," + getCollectionToString(this.demandSkills) + ","
                    + this.supplyId + "," + getCollectionToString(this.supplySkills) + ","
                    + this.supplyGrade + "," + this.demandGrade + "," + this.matchPercentage + ","
                    + this.matchingGrade + "," + this.matchingGradePercentage + ","
                    + getCollectionToString(this.matchingSkills);
        }

        private String getCollectionToString(Collection<String> c) {
            StringBuffer strb = new StringBuffer();
            for (String s : c) {
                strb.append(s + "|");
            }
            return strb.toString();
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.getDemandId(), this.getSupplyId());
        }

        @Override
        public boolean equals(Object obj) {
            MatchResult that = (MatchResult) obj;
            return this.getDemandId().equalsIgnoreCase(that.getDemandId())
                    && this.getSupplyId().equalsIgnoreCase(that.getSupplyId());
        }
    }

    private class Demand {
        String id;
        Set<String> skillSet;
        Grade_Rank rank;
    }

    private class Supply {
        String id;
        Set<String> skillSet;
        Grade_Rank rank;
    }
}
