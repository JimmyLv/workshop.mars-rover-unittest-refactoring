public class Direction {
    private static final String[] DIRECTIIONS = new String[]{
            "N", "E", "S", "W"
    };

    public static String trunLeft(String directon) {

        int i;
        for (i = 0; i < DIRECTIIONS.length; i++) {

            if (DIRECTIIONS[i].equals(directon)) {

                break;
            }
        }

        return DIRECTIIONS[(i + 3) % 4];
    }

    public static  String trunRight(String directon) {

        int i;
        for (i = 0; i < DIRECTIIONS.length; i++) {

            if (DIRECTIIONS[i].equals(directon)) {

                break;
            }
        }

        return DIRECTIIONS[(i + 1) % 4];
    }

}
