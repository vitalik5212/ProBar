package com.lessons.home.springsecurity.logic;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.*;
import java.util.Random;

public class TestFileCopier {

    @Test
    public void copy() throws IOException {
        File file = new File("/");
        Random random = new Random();
        OutputStream outputStream = new FileOutputStream(file);
        for (int i = 0; i < 100; i++) {
            outputStream.write(random.nextInt());
        }

        FileCopier.copy(file.getName());
        Assert.isTrue(false);
    }
}
