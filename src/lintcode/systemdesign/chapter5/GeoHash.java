package lintcode.systemdesign.chapter5;

public class GeoHash {
    /*
     * @param latitude: one of a location coordinate pair
     * @param longitude: one of a location coordinate pair
     * @param precision: an integer between 1 to 12
     * @return: a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        String lat = get(latitude, -90, 90);
        String lng = get(longitude, -180, 180);

        StringBuilder hash_code = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            sb.append(lng.charAt(i));
            sb.append(lat.charAt(i));
        }

        for (int i = 0; i < 60; i += 5) {
            int index = b2i(sb.substring(i, i + 5));
            hash_code.append(base32.charAt(index));
        }
        return hash_code.substring(0, precision);
    }

    public int b2i(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public String get(double value, double left, double right) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            double mid = left + (right - left) / 2;
            if (value > mid) {
                left = mid;
                sb.append("1");
            } else {
                right = mid;
                sb.append("0");
            }
        }
        return sb.toString();
    }
}
