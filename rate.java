public class RateLimiter {
    /**
     * @param timestamp the current timestamp
     * @param event the string to distinct different event
     * @param rate the format is [integer]/[s/m/h/d]
     * @param increment whether we should increase the counter
     * @return true or false to indicate the event is limited or not
     */
     Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // Write your code here
        String[] parserate = rate.split("/");
        int standard = Integer.parseInt(parserate[0]);
        int time = 1;
        if (parserate[1].equals("s")) {
            time = time * 1;
        } else if (parserate[1].equals("m")) {
            time = time * 60;
        } else if (parserate[1].equals("h")) {
            time = time * 60 * 60;
        } else  {
            time = time * 60 * 60 * 24;
        }
        int lasttime = timestamp - time + 1;
        if (!map.containsKey(event)) {
            map.put(event, new ArrayList<Integer>());
        }
        boolean rt = (checkValid(map.get(event), lasttime) >= standard);
        if (increment && !rt) {
            map.get(event).add(timestamp);
        }
        return rt;
    }
    
    public int checkValid(List<Integer> list, int lasttime) {
        int start = 0;
        int end = list.size() - 1;
        if (end < 0) {
            return 0;
        }
        if (list.get(end) < lasttime) {
            return 0;
        }
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < lasttime) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return list.size() - ans;
    }
}
