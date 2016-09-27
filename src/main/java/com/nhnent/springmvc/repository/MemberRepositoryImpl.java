package com.nhnent.springmvc.repository;

import com.nhnent.springmvc.model.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository("memberRepository")
public class MemberRepositoryImpl implements MemberRepository {
    @Resource
    @Qualifier("memberMap")
    Map<String, Member> memberMap;


    @Override
    public Member find(String id, String password) {
        Member member = memberMap.get(id);
        if (member == null) {
            return null;
        }

        if (!Objects.equals(member.getPassword(), password)) {
            return null;
        }

        return member;
    }

    @Override
    public Member get(String id) {
        return memberMap.getOrDefault(id, null);
    }

    @Override
    public List<Member> list() {
        return new ArrayList<>(memberMap.values());
    }

}
