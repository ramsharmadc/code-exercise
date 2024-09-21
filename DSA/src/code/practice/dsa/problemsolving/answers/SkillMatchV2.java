package dsa.problemsolving.answers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class SkillMatchV2 {

    private final String supplyInputFilePath;
    private final String supplyInputFileName;
    private final String outputFileName;
    private final boolean demandBased = true;
    private Map<String, DemandSupplyPair> demandToSupplyMap;

    public SkillMatchV2() {
        System.out.println("Initializing system...");
        supplyInputFilePath = "D:\\out";
        supplyInputFileName = "demo.csv";
        outputFileName = "DesiredOutput.csv";
        System.out.println("Initializing system complete.");
    }

    public static void main(String[] args) {
        System.out.println("Starting the Supply-Demand allocation.");
        SkillMatchV2 sm = new SkillMatchV2();
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
            fos.write(
                    ("Associate ID,Unique ID,Technical Skills Required,Skills_Consumed,Matched Skills,Out Of,Match Percentage\n")
                            .getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            for (String id : demandToSupplyMap.keySet()) {
                if (demandToSupplyMap.containsKey(id)) {
                    String assocId = demandToSupplyMap.get(id).associateId;
                    Set<String> demands = demandToSupplyMap.get(id).demand.demandSet;
                    Set<String> skills = demandToSupplyMap.get(id).supply.skillSet;
                    Set<MatchResult> m = prepareMetrics(id, assocId, demands, skills);
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

    private Map<String, DemandSupplyPair> readSupplyInputFile(String filePath, String fileName)
            throws Exception {
        System.out.println("Reading input file - " + filePath + "\\" + fileName);
        FileInputStream fis = new FileInputStream(filePath + "\\" + fileName);
        Scanner fileScnr = new Scanner(fis);
        Map<String, DemandSupplyPair> inputSupplies = new LinkedHashMap<>();
        boolean headerLine = true;
        String uniqueId;
        String associateId;
        while (fileScnr.hasNext()) {
            String nxtLine = fileScnr.nextLine();
            if (headerLine) {
                headerLine = false;
                continue;
            }
            if (nxtLine != null && !nxtLine.isEmpty()) {
                String demandSkillStr = nxtLine.substring(0, nxtLine.lastIndexOf(","));
                String[] leftSide = demandSkillStr.split(",");
                associateId = leftSide[0].trim().replaceAll("\"", "").trim().replaceAll(",", "")
                        .trim().replaceAll(";", "").trim();
                uniqueId = leftSide[1].trim().replaceAll("\"", "").trim().replaceAll(",", "").trim()
                        .replaceAll(";", "").trim();
                String supplySkillStr = nxtLine.substring(nxtLine.lastIndexOf(","));
                String[] demandSkillArr =
                        leftSide.length >= 3 ? leftSide[2].split(";") : new String[]{""};
                String[] supplySkillArr = supplySkillStr.split(";");
                Set<String> demandSkillSet = new LinkedHashSet<>();
                Set<String> supplySkillSet = new LinkedHashSet<>();
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
                inputSupplies.put(uniqueId, new DemandSupplyPair(uniqueId, associateId,
                        new Demand(demandSkillSet), new Supply(supplySkillSet)));
                // id += 1;
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

    private Set<MatchResult> prepareMetrics(String id, String assocId, Set<String> demands,
                                            Set<String> supplies) {
        Set<MatchResult> s = new LinkedHashSet<>();
        MatchResult[] m = new MatchResult[supplies.size()];
        Set<String> matchedSkills = new LinkedHashSet<>();
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
            mtch.setUniqueId(id);
            mtch.setAssociateId(assocId);
            mtch.setOutOf(Double.valueOf(matchedSkills.size()) + "/"
                    + (demandBased ? Double.valueOf(demands.size())
                    : Double.valueOf(supplies.size())));
            s.add(mtch);
        } else {
            MatchResult mtch = new MatchResult();
            mtch.setMatchPercentage(0);
            mtch.setMatchingSkills(new LinkedHashSet<>());
            mtch.setDemandSkills(demands);
            mtch.setSupplySkills(supplies);
            mtch.setUniqueId(id);
            mtch.setAssociateId(assocId);
            mtch.setOutOf("0");
            s.add(mtch);
        }
        return s;
    }

    private class MatchResult {
        private String uniqueId;
        private String associateId;
        private Set<String> demandSkills;
        private Set<String> supplySkills;
        private double matchPercentage;
        private Set<String> matchingSkills;
        private String outOf;

        public String getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
        }

        public String getAssociateId() {
            return associateId;
        }

        public void setAssociateId(String associateId) {
            this.associateId = associateId;
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

        public String getOutOf() {
            return outOf;
        }

        public void setOutOf(String outOf) {
            this.outOf = outOf;
        }

        @Override
        public String toString() {
            return getAssociateId() + "," + getUniqueId() + ","
                    + getCollectionToString(this.demandSkills, ";") + ","
                    + getCollectionToString(this.supplySkills, ";") + ","
                    + getCollectionToString(this.matchingSkills, ";") + "," + this.outOf + ","
                    + this.matchPercentage;
        }

        private String getCollectionToString(Collection<String> c, String delimiter) {
            StringBuffer strb = new StringBuffer();
            if (c.size() > 0) {
                for (String s : c) {
                    strb.append(s + delimiter);
                }
                return strb.toString().substring(0, strb.toString().lastIndexOf(delimiter));
            } else
                return "";
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.getDemandSkills(), this.getSupplySkills());
        }

        @Override
        public boolean equals(Object obj) {
            MatchResult that = (MatchResult) obj;
            return this.getUniqueId().equalsIgnoreCase(that.getUniqueId());
        }
    }

    private class DemandSupplyPair {
        private final String uniqueId;
        private final String associateId;
        private final Demand demand;
        private final Supply supply;

        public DemandSupplyPair(String uniqueId, String associateId, Demand demand, Supply supply) {
            this.uniqueId = uniqueId;
            this.associateId = associateId;
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
