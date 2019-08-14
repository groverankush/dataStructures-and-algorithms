package com.ankushgrover.problems;

import java.util.HashSet;

public class P44UniqueEmailAddresses {

    public static void main(String [] args){
        String [] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    private static int numUniqueEmails(String[] emails) {

        if(emails == null || emails.length == 0)
            return 0;

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < emails.length; i++){
            String email = getValidEmail(emails[i]);
            set.add(email);
        }

        return set.size();
    }

    private static String getValidEmail(String email){

        StringBuilder builder = new StringBuilder();
        boolean hasPlus = false;
        int i;
        for(i = 0; i < email.length(); i++){

            char ch = email.charAt(i);

            if(ch == '@'){
                break;
            }

            if(hasPlus || ch == '+') {
                hasPlus = true;
                continue;
            }

            if(ch == '.'){
                continue;
            }


            builder.append(ch);
        }

        while(i < email.length()){
            char ch = email.charAt(i);

            builder.append(ch);
            i++;
        }
        return builder.toString();
    }

}
