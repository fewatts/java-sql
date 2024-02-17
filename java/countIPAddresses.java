
public class countIPAddresses {
    public static long ipToLong(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result += Long.parseLong(parts[i]) << (24 - (8 * i));
        }
        return result;
    }

    public static long ipsBetween(String startIP, String endIP) {
        long start = ipToLong(startIP);
        long end = ipToLong(endIP);
        return end - start;
    }

}
