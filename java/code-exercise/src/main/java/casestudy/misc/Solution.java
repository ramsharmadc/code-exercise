package casestudy.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
                + "john.png, London, 2015-06-20 15:13:22\n"
                + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
                + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
                + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
                + "BOB.jpg, London, 2015-08-05 00:02:03\n"
                + "notredame.png, Paris, 2015-09-01 12:00:00\n"
                + "me.jpg, Warsaw, 2013-09-06 15:40:22\n" + "a.png, Warsaw, 2016-02-13 13:33:50\n"
                + "b.jpg, Warsaw, 2016-01-02 15:12:22\n" + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
                + "d.jpg, Warsaw, 2016-01-02 15:15:01\n" + "e.png, Warsaw, 2016-01-02 09:49:09\n"
                + "f.png, Warsaw, 2016-01-02 10:55:32\n" + "g.jpg, Warsaw, 2016-02-29 22:13:11";

        String sp = new Solution().solution(s);
        System.out.println(sp);

        int[] a = new int[]{-5, -5, -5, -42, 6, 12};
        // int[] a = new int[]{5, -2, 3, 8, 6};
        int n = new Solution().solution2(a);
        System.out.println(n);
    }

    private static int min(int a, int b) {
        return (a < b ? a : b);
    }

    public String solution(String S) {
        // write your code in Java SE 8

        String[] s = S.split("\n");
        List<PhotoDetail> l = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            PhotoDetail p = extractPhotoDetail(s[i].trim());
            if (p != null) {
                p.pos = i + 1;
                l.add(p);
            }
        }

        Map<String, Set<PhotoDetail>> mp = new HashMap<>();

        for (PhotoDetail d : l) {
            if (mp.containsKey(d.getCityName())) {
                Set<PhotoDetail> st = mp.get(d.getCityName());
                st.add(d);
            } else {
                Set<PhotoDetail> st = new TreeSet<>(new Comparator<PhotoDetail>() {
                    @Override
                    public int compare(PhotoDetail p1, PhotoDetail p2) {
                        if (p1 != null && p2 != null) {
                            return p1.getClickTime().compareTo(p2.getClickTime());
                        } else
                            return 0;
                    }
                });
                st.add(d);
                mp.put(d.getCityName(), st);
            }
        }

        Set<PhotoDetail> fs = new TreeSet<>(new Comparator<PhotoDetail>() {
            @Override
            public int compare(PhotoDetail p1, PhotoDetail p2) {
                return p1.getPos() == p2.getPos() ? 1 : (p1.getPos() > p2.getPos() ? 1 : -1);
            }
        });

        for (Map.Entry<String, Set<PhotoDetail>> e : mp.entrySet()) {
            int i = 1;
            Set<PhotoDetail> d = e.getValue();

            int n = 1;
            int lim = d.size();

            for (PhotoDetail p : d) {
                if (lim == 1)
                    n = String.valueOf(i).length();
            }

            for (PhotoDetail p : d) {
                p.setId(p.getCityName() + "" + getLeftPaddedString(n, '0') + "" + i++);
                fs.add(p);
            }
        }

        StringBuffer sb = new StringBuffer();

        for (PhotoDetail d : fs) {
            sb.append(d.getId());
            sb.append("." + d.extn);
            sb.append("\n");
        }

        return sb.toString();
    }

    private PhotoDetail extractPhotoDetail(String s) {
        if (s == null || s == "")
            return null;

        String[] a = s.split(",");

        if (a.length != 3)
            return null;

        PhotoDetail p = new PhotoDetail();

        String n = a[0].trim();
        String n1 = n.substring(0, n.indexOf("."));
        String n2 = n.substring(n.indexOf(".") + 1);

        p.photoName = n1;
        p.cityName = a[1].trim();

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d = null;
        try {
            d = fmt.parse(a[2].trim());
        } catch (ParseException e) {
            return null;
        }
        p.clickTime = d;
        p.extn = n2;

        return p;
    }

    protected String getLeftPaddedString(int length, char charToFill) {
        if (length > 0) {
            char[] array = new char[length];
            Arrays.fill(array, charToFill);
            return new String(array);
        }
        return "";
    }

    public int solution2(int[] T) {
        // write your code in Java SE 8

        int e = findWinterEnd(T);
        int[] W = new int[e];

        for (int i = 0; i < e; i++) {
            W[i] = T[i];
        }

        // int minWinterLen = findMinWinterLen(W);
        int minWinterLen = findMinWinter(W, 0, 0);
        return minWinterLen;
    }

    private int findWinterEnd(int[] T) {
        int r = -1;
        for (int i = 0; i < (T.length - 1); i++) {
            r = i;
            if (T[i] < 0 && T[i + 1] < 0 && T[i] >= T[i + 1]) {
                continue;
            } else if (T[i] <= T[i + 1]) {
                continue;
            }
        }
        return r;
    }

    private int findMinWinter(int[] W, int i, int min) {
        if (i >= W.length)
            return i;
        else
            return min(findMinWinter(W, i + 1, min), findMinWinter(W, i + 1, min + W[i]));
    }

    private int findMinWinterLen(int[] W) {
        int minSoFar = 0, min_ending_here = 0, r = -1;
        for (int i = 0; i < W.length; i++) {
            min_ending_here = min(0, min_ending_here + W[i]);
            minSoFar = min(minSoFar, min_ending_here);

            if (minSoFar >= min_ending_here) {
                r = i;
                break;
            }

        }
        return r + 1;
    }

    private class PhotoDetail {
        private String photoName;
        private String cityName;
        private Date clickTime;
        private String extn;
        private int pos;
        private String id;

        public String getPhotoName() {
            return photoName;
        }

        public void setPhotoName(String photoName) {
            this.photoName = photoName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Date getClickTime() {
            return clickTime;
        }

        public void setClickTime(Date clickTime) {
            this.clickTime = clickTime;
        }

        public String getExtn() {
            return extn;
        }

        public void setExtn(String extn) {
            this.extn = extn;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
