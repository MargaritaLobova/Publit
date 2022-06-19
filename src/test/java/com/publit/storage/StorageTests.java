package com.publit.storage;

import com.publit.data.dao.repos.S3Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootTest
class StorageTests {

    @Autowired
    private S3Repository repository;

    @Test
    void storageUploadingIsCorrect() {
        var filename = "test.txt";
        var stream = getClass().getClassLoader().getResourceAsStream(filename);
        repository.addFile(filename, stream);
    }

    @Test
    void storageDownloadingIsCorrect() {
        var filename = "remote_test.txt";
        var stream = repository.getFileStream(filename);
        new BufferedReader(new InputStreamReader(stream)).lines().forEach(System.out::println);
    }
}
