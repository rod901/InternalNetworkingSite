package com.internal.site;

import com.internal.site.main.InternalNetworkingSite;

public class Main {

    public static void main(String[] args) {
        String[] employeesInput = {
                "1,Richard,Engineering",
                "2,Erlich,HR",
                "3,Monica,Business",
                "4,Dinesh,Engineering",
                "6,Carla,Engineering"
        };

        String[] friendshipsInput = {
                "1,2",
                "1,3",
                "2,4"
        };

        InternalNetworkingSite internalNetworkingSite = new InternalNetworkingSite(friendshipsInput, employeesInput);
        internalNetworkingSite.associateFriends();
    }
}
