package test.answers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class SkillMatchV3 {

    private final String supplyInputFilePath;
    private final String supplyInputFileName;
    private final String outputFileName;
    private final boolean demandBased = true;
    private Map<Integer, DemandSupplyPair> demandToSupplyMap;

    public SkillMatchV3() {
        System.out.println("Initializing system...");
        supplyInputFilePath = "D:\\out";
        supplyInputFileName = "demo.csv";
        outputFileName = "DesiredOutput.csv";
        System.out.println("Initializing system complete.");
    }

    public static void main(String[] args) {
        System.out.println("Starting the Supply-Demand allocation.");
        SkillMatchV3 sm = new SkillMatchV3();
        sm.readSupply();
        sm.prepareMatchMetrics();
        System.out.println("Finished the Supply-Demand allocation.");
    }

    private void readSupply() {
        System.out.println("Reading Supply/Demand...");
        try {
            demandToSupplyMap = readSupplyInputFile(supplyInputFilePath, supplyInputFileName);
        } catch (Exception e) {
            System.out.println("ERROR WHILE READING SUPPLY DATA.");
            e.printStackTrace();
        }
        System.out.println("Reading Supply/Demand finished.");
    }

    private void prepareMatchMetrics() {
        System.out.println("Preparing Supply-Demand match Metrics ...");
        long started = Calendar.getInstance().getTimeInMillis();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(supplyInputFilePath + "\\" + outputFileName, false);
            fos.write(("Demand Skills, Supply Skills, Matching Skills, Match Percentage\n")
                    .getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            for (Integer id : demandToSupplyMap.keySet()) {
                if (demandToSupplyMap.containsKey(id)) {
                    Set<String> demands = demandToSupplyMap.get(id).demand.demandSet;
                    Set<String> skills = demandToSupplyMap.get(id).supply.skillSet;
                    Set<MatchResult> m = prepareMetrics(id, demands, skills);
                    for (MatchResult mr : m) {
                        if (mr != null) {
                            String sb = mr.toString() + "\n";
                            try {
                                fos.write(sb.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
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

    private Map<Integer, DemandSupplyPair> readSupplyInputFile(String filePath, String fileName)
            throws Exception {
        System.out.println("Reading input file - " + filePath + "\\" + fileName);
        FileInputStream fis = new FileInputStream(filePath + "\\" + fileName);
        Scanner fileScnr = new Scanner(fis);
        Map<Integer, DemandSupplyPair> inputSupplies = new HashMap<>();
        boolean headerLine = true;
        Integer id = 1;
        while (fileScnr.hasNext()) {
            String nxtLine = fileScnr.nextLine();
            if (headerLine) {
                headerLine = false;
                continue;
            }
            if (nxtLine != null && !nxtLine.isEmpty()) {
                String demandSkillStr = nxtLine.substring(0, nxtLine.lastIndexOf(","));
                String supplySkillStr = nxtLine.substring(nxtLine.lastIndexOf(","));
                String[] demandSkillArr = demandSkillStr.split(",");
                String[] supplySkillArr = supplySkillStr.split(";");
                Set<String> demandSkillSet = new HashSet<>();
                Set<String> supplySkillSet = new HashSet<>();
                for (int i = 0; i < demandSkillArr.length; i++) {
                    if (demandSkillArr[i] != null && !(demandSkillArr[i].equals(""))) {
                        String demandSkill = demandSkillArr[i].trim().replaceAll("\"", "").trim()
                                .replaceAll(",", "").trim().replaceAll(";", "").trim();
                        demandSkillSet.add(demandSkill);
                    }
                }
                for (int i = 0; i < supplySkillArr.length; i++) {
                    if (supplySkillArr[i] != null && !(supplySkillArr[i].equals(""))) {
                        String supplySkill = supplySkillArr[i].trim().replaceAll("\"", "").trim()
                                .replaceAll(",", "").trim().replaceAll(";", "").trim();
                        supplySkillSet.add(supplySkill);
                    }
                }
                inputSupplies.put(id, new DemandSupplyPair(id, new Demand(demandSkillSet),
                        new Supply(supplySkillSet)));
                id += 1;
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

    private Set<MatchResult> prepareMetrics(Integer id, Set<String> demands, Set<String> supplies) {
        Set<MatchResult> s = new HashSet<>();
        MatchResult[] m = new MatchResult[supplies.size()];
        Set<String> matchedSkills = new HashSet<>();
        for (String demand : demands) {
            for (String supply : supplies) {
                if (Objects.equals(demand, supply)) {
                    matchedSkills.add(demand);
                }
            }
        }
        if (matchedSkills.size() > 0) {
            MatchResult mtch = new MatchResult();
            mtch.setMatchPercentage((Double.valueOf(matchedSkills.size())
                    / (demandBased ? Double.valueOf(demands.size())
                    : Double.valueOf(supplies.size()))
                    * 100));
            mtch.setMatchingSkills(matchedSkills);
            mtch.setDemandSkills(demands);
            mtch.setSupplySkills(supplies);
            mtch.setDemandId(id.toString());
            s.add(mtch);
        }
        return s;
    }

    private class MatchResult {
        private String demandId;
        private Set<String> demandSkills;
        private Set<String> supplySkills;
        private double matchPercentage;
        private Set<String> matchingSkills;

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

        public Set<String> getSupplySkills() {
            return supplySkills;
        }

        public void setSupplySkills(Set<String> supplySkills) {
            this.supplySkills = supplySkills;
        }

        public void setMatchPercentage(double matchPercentage) {
            this.matchPercentage = matchPercentage;
        }

        public void setMatchingSkills(Set<String> matchingSkills) {
            this.matchingSkills = matchingSkills;
        }

        @Override
        public String toString() {
            return getCollectionToString(this.demandSkills, ";") + ","
                    + getCollectionToString(this.supplySkills, ";") + ","
                    + getCollectionToString(this.matchingSkills, ";") + "," + this.matchPercentage;
        }

        private String getCollectionToString(Collection<String> c, String delimiter) {
            StringBuffer strb = new StringBuffer();
            for (String s : c) {
                strb.append(s + delimiter);
            }
            return strb.toString().substring(0, strb.toString().lastIndexOf(delimiter));
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.getDemandSkills(), this.getSupplySkills());
        }

        @Override
        public boolean equals(Object obj) {
            MatchResult that = (MatchResult) obj;
            return this.getDemandId().equalsIgnoreCase(that.getDemandId())
                    && this.getDemandId().equalsIgnoreCase(that.getDemandId());
        }
    }

    private class DemandSupplyPair {
        private final Integer id;
        private final Demand demand;
        private final Supply supply;

        public DemandSupplyPair(Integer id, Demand demand, Supply supply) {
            this.id = id;
            this.demand = demand;
            this.supply = supply;
        }
    }

    private class Demand {
        Set<String> demandSet;

        public Demand(Set<String> demandSet) {
            this.demandSet = demandSet;
        }
    }

    private class Supply {
        Set<String> skillSet;

        public Supply(Set<String> skillSet) {
            this.skillSet = skillSet;
        }
    }
}
