/*
 * Copyright 2024 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */

package com.example.samplespringboot2javagradle.service;

import com.example.samplespringboot2javagradle.dto.MemberReqDto;
import com.example.samplespringboot2javagradle.dto.MemberRspDto;
import com.example.samplespringboot2javagradle.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>Member Service
 *
 * @author dongyoung.kim
 * @since 1.0
 */
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberRspDto saveMember(MemberReqDto memberReqDto) {
        var member = memberRepository.save(memberReqDto.toEntity());
        return new MemberRspDto(member);
    }

    public MemberRspDto findMember(Long id) {
        return memberRepository.findById(id)
            .map(MemberRspDto::new)
            .orElseGet(MemberRspDto::new);
    }

}
