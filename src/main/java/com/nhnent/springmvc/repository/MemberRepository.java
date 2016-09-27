package com.nhnent.springmvc.repository;

import com.nhnent.springmvc.model.Member;

import java.util.List;

public interface MemberRepository {
    Member find(String id, String password);
    Member get(String id);

    List<Member> list();

}
