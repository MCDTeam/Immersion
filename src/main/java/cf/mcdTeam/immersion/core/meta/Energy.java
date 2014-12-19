package cf.mcdTeam.immersion.core.meta;

public class Energy {

    public enum Wired {

        QM("Joules", "J");

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


    public class Values {

        public static final int ELECTRICAL_WIRE_TRANSFERE = 200;

        public static final int CREATIVE_CELL_STORAGE = 50000000;
        public static final int BASIC_CELL_STORAGE = 5000;

    }
}
