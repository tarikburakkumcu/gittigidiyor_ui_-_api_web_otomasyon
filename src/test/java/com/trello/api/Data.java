package com.trello.api;


import java.util.HashMap;

public class Data {
    String Key = "7e63c980de5941dd8062972aef455d10";
    String Token = "0743a002cc700bebacb4a4fd58cb6a6e21a91c1134b66a9c9f55ae05a3bfb5fa";
    String Name = "Testinium";
    String Listname= "ListTest";
    String updatename="NewCard";

    public HashMap<String, String> postBoardData(){
        HashMap<String,String> postBodyMap=new HashMap<>();
        postBodyMap.put("key",Key);
        postBodyMap.put("token",Token);
        postBodyMap.put("name",Name);
        return postBodyMap;
    }

    public HashMap<String, String> postListData(){
        HashMap<String,String> postBodyMap=new HashMap<>();
        postBodyMap.put("key",Key);
        postBodyMap.put("token",Token);
        postBodyMap.put("name",Listname);
        postBodyMap.put("idBoard", TestCaseApi.boardId);
        return postBodyMap;
    }

    public HashMap<String, String> postCardData(){
        HashMap<String,String> postBodyMap=new HashMap<>();
        postBodyMap.put("key",Key);
        postBodyMap.put("token",Token);
        postBodyMap.put("idList", TestCaseApi.listId);
        return postBodyMap;
    }

    public HashMap<String, String> updateData(){
        HashMap<String,String> updateBodyMap=new HashMap<>();
        updateBodyMap.put("key",Key);
        updateBodyMap.put("token",Token);
        updateBodyMap.put("name",updatename );
        return updateBodyMap;
    }

    public HashMap<String, String> delete(){
        HashMap<String,String> deleteMap=new HashMap<>();
        deleteMap.put("key",Key);
        deleteMap.put("token",Token);
        return deleteMap;
    }

}
