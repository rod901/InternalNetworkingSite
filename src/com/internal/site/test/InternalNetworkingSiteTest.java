package com.internal.site.test;

import com.internal.site.main.InternalNetworkingSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

class InternalNetworkingSiteTest {
    String[] employeesInput;
    String[] friendshipsInput;
    InternalNetworkingSite internalNetworkingSite;

    @BeforeEach
    void setUp() {
        employeesInput = new String[]{
                "1,Richard,Engineering",
                "2,Erlich,HR",
        };

        friendshipsInput = new String[]{
                "1,2",
        };
        internalNetworkingSite = new InternalNetworkingSite(friendshipsInput, employeesInput);
    }

    @Test
    void seperateCommas() {
        Map<Integer, String[]> expectedMap = new HashMap<>();
        for (int i = 0; i < friendshipsInput.length; i++) {
            expectedMap.put(i, friendshipsInput[i].split(","));
        }

        Map<Integer, String[]> actualMap = internalNetworkingSite.seperateCommas(friendshipsInput);

        expectedMap.keySet().iterator().forEachRemaining(key -> {
            Assertions.assertTrue(expectedMap.keySet().equals(actualMap.keySet()));
            Assertions.assertTrue(Arrays.equals(expectedMap.get(key), actualMap.get(key)));
        });
    }

    @Test
    void seperateEmployees() {
        Map<Integer, String[]> expectedMap = new HashMap<>();
        expectedMap.put(1, new String[]{String.valueOf(1)});
        expectedMap.put(2, new String[]{String.valueOf(2)});

        Map<Integer, String[]> actualMap = internalNetworkingSite.seperateEmployees(employeesInput);

        expectedMap.keySet().iterator().forEachRemaining(key -> {
            Assertions.assertTrue(expectedMap.keySet().equals(actualMap.keySet()));
            Assertions.assertTrue(Arrays.equals(expectedMap.get(key), actualMap.get(key)));
        });
    }

    @Test
    void seperateFriendships() {
        Map<Integer, String[]> expectedMap = new HashMap<>();
        expectedMap.put(0, new String[]{"1", "2"});

        Map<Integer, String[]> actualMap = internalNetworkingSite.seperateFriendships(friendshipsInput);

        expectedMap.keySet().iterator().forEachRemaining(key -> {
            Assertions.assertTrue(expectedMap.keySet().equals(actualMap.keySet()));
            Assertions.assertTrue(Arrays.equals(expectedMap.get(key), actualMap.get(key)));
        });
    }

    @Test
    void associateFriends() {
        InternalNetworkingSite internalNetworkingSite = mock(InternalNetworkingSite.class);
        doCallRealMethod().when(internalNetworkingSite).associateFriends();
        internalNetworkingSite.associateFriends();

        verify(internalNetworkingSite, times(1)).associateFriends();
    }
}