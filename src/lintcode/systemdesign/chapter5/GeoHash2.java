package lintcode.systemdesign.chapter5;

/**
 * 530. Geo Hash 2
 */
public class GeoHash2 {
    /*
     * @param geohash: geohash a base32 string
     * @return: latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        int[] mask = {16, 8, 4, 2, 1};
        double[] lon = {-180, 180};
        double[] lat = {-90, 90};
        boolean is_even = true;

        for (int i = 0; i < geohash.length(); i++) {
            int val = base32.indexOf(geohash.charAt(i));
            for (int j = 0; j < 5; j++) {
                if (is_even) {
                    helper(lon, val, mask[j]);
                } else {
                    helper(lat, val, mask[j]);
                }
                is_even = !is_even;
            }
        }
        double[] location = {(lat[0] + lat[1]) / 2, (lon[0] + lon[1]) / 2};
        return location;
    }

    private void helper(double[] interval, int val, int mask) {
        if ((val & mask) > 0) {
            interval[0] = (interval[0] + interval[1]) / 2;
        } else {
            interval[1] = (interval[0] + interval[1]) / 2;
        }
    }
}
