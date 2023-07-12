package com.cjk;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.GitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String USERNAME = "wlicjk@126.com";
    private static final String PASSWORD = "cjk@38756175";
    private static final String LOCALPATH = "E:\\Code\\SSC\\admin";
    private static final Integer LENGTH = "http://192.168.0.40:4071/".length();

    public static void main(String[] args) throws GitAPIException {
        List<String> addrList = new ArrayList<>();
        addrList.add("http://192.168.0.40:4071/opensource-main/opensource-web");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-common");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-thirdparty");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-html");
//        addrList.add("http://192.168.0.40:4071/opensource-main/secyun-oss-thirdparty");
//        addrList.add("http://192.168.0.40:4071/opensource-main/secyun-oss-component");
//        addrList.add("http://192.168.0.40:4071/opensource-main/secyun-oss-license");
//        addrList.add("http://192.168.0.40:4071/opensource-main/secyun-oss-vulnerability");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-pom");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-program-name");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-start");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-user");
//        addrList.add("http://192.168.0.40:4071/project-common/secyun-scc-components");
//        addrList.add("http://192.168.0.40:4071/opensource-main/secyun-open-source-scanning");

        for (String s : addrList) {
            GitCommand(s);
        }
    }

    public static void GitCommand(String uri) throws GitAPIException {
        String[] split = uri.substring(LENGTH).split("/");
        Git git = Git.cloneRepository().setURI(uri)
                .setDirectory(new File(LOCALPATH + "\\" + split[1]))
                .setCredentialsProvider(provide())
                .call();
    }

    private static UsernamePasswordCredentialsProvider provide() {
        return new UsernamePasswordCredentialsProvider(USERNAME, PASSWORD);
    }
}