package com.easybusan.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CreateInsertUtil {

    private static Map<String, Integer> map;

    private static void setMap() {
        map = new HashMap<>();
        map.put("강서구", 1);
        map.put("금정구", 2);
        map.put("기장군", 3);
        map.put("남구", 4);
        map.put("동구", 5);
        map.put("동래구", 6);
        map.put("부산진구", 7);
        map.put("북구", 8);
        map.put("사상구", 9);
        map.put("사하구", 10);
        map.put("서구", 11);
        map.put("수영구", 12);
        map.put("연제구", 13);
        map.put("영도구", 14);
        map.put("중구", 15);
        map.put("해운대구", 16);
    }

    public static class Node implements Comparable<Node> {
        int rank;
        String ssg;
        int kindId;

        public Node(int rank, String ssg, int kindId) {
            this.rank = rank;
            this.ssg = ssg;
            this.kindId = kindId;
        }

        @Override
        public int compareTo(Node o) {
            return this.kindId - o.kindId;
        }
    }

    public static void create(String str, String type) {
        BufferedReader br = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();
        int N = 16;
        setMap();
        Node[] nodes = new Node[N];
        int T = 0;
        if (type.endsWith("TRADE")) {
            T = 2;
        } else {
            T = 4;
        }
        sb.append("-- ").append(type).append('\n');
        while (T-- > 0) {
            String type2 = null;
            try {
                type2 = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sb.append("-- ").append(type2).append('\n');
            int sectionId = getSectionId(type, type2);
            for (int i = 0; i < N; i++) {
                StringTokenizer st = null;
                try {
                    st = new StringTokenizer(br.readLine(), ":");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String ssg = st.nextToken();
                int rank = Integer.parseInt(st.nextToken());
                int kindId = map.get(ssg);
                nodes[i] = new Node(rank, ssg, kindId);
            }
            Arrays.sort(nodes);
            for (int i = 0; i < N; i++) {
                sb.append("INSERT INTO kind_rank (kind_id, section_id, rank) VALUES (");
                sb.append(nodes[i].kindId).append(", ").append(sectionId).append(", ").append(nodes[i].rank).append(");");
                sb.append(" -- ").append(nodes[i].ssg).append("\n");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static int getSectionId(String type, String type2) {
        int sectionId = 0;
        if (type.startsWith("APT")){
            sectionId = 11;
        } else if (type.startsWith("RH")){
            sectionId = 17;
        } else if (type.startsWith("OFFI")){
            sectionId = 23;
        } else if (type.startsWith("SH")){
            sectionId = 33;
        } else {
            sectionId = 29;
        }
        if (type.endsWith("TRADE")){
            if (type2.equals("amount")){
                sectionId += 2;
            } else {
                sectionId += 3;
            }
        } else if (type.endsWith("RENT")){
            if (type2.equals("count")){
                sectionId += 5;
            } else if (type2.equals("amount")){
                sectionId += 4;
            } else if (type2.equals("count2")){
                sectionId += 1;
            }
        } else {
            if (type2.equals("amount")){
                sectionId += 2;
            } else if (type2.equals("count")){
                sectionId += 3;
            } else if (type2.equals("count2")){
                sectionId += 1;
            }
        }
        return sectionId;
    }

}