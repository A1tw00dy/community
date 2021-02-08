package com.travel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void time(){
        System.out.println(System.currentTimeMillis());
    }

}
