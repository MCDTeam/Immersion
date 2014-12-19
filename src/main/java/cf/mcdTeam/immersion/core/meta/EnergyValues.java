package cf.mcdTeam.immersion.core.meta;

public class EnergyValues {

    public enum Wired {

        IM("Immersion Units", "IM"); //TODO

        private String name;
        private String symbol;

        private Wired(String name, String symbol) {
            this.name = name;
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getPlural() {
            return name + "s";
        }
    }

    public static class Values{

        public static final int ELECTRICAL_WIRE_STORGE = 100;

        public static final int ELECTRICAL_WIRE_TRANSFERE = 100;
    }
}
