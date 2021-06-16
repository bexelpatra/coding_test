package com.test.practice.f_dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DFSBFS_4 {
    class Ticket{
         private String from;
         private String to;

        public String getFrom() { return from; }
        public String getTo() { return to; }

        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        List<Ticket> ans = new ArrayList<>();
        List<Ticket> result = new ArrayList<>();
//        for (String[] ticket : tickets) {
        for (int i=0;i<tickets.length;i++) {
            String[] starter = tickets[i];
            String from = starter[0];
            String to = starter[1];
            ans.add(new Ticket(from,to));
        }

        return answer;
    }

    public void re(String to,List<Ticket> now,List<Ticket> result){
        now.stream().filter(ticket -> ticket.getTo().equals(to)).collect(Collectors.toList());
    }

    private void recursive(){

    }
}
