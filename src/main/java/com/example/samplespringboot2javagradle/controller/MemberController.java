/*
 * Copyright 2024 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */

package com.example.samplespringboot2javagradle.controller;

import com.example.samplespringboot2javagradle.dto.MemberReqDto;
import com.example.samplespringboot2javagradle.dto.MemberRspDto;
import com.example.samplespringboot2javagradle.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Member Controller
 * for test db CRUD
 *
 * @author dongyoung.kim
 * @since 1.0
 */
@Tag(name = "Member Controller", description = "DB CRUD용 회원 컨트롤러")
@RequestMapping("member/v1")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", useReturnTypeSchema = true),
    })
    @Operation(summary = "회원 저장", description = "회원 데이터 저장 API")
    @PostMapping
    public MemberRspDto saveMember(@RequestBody MemberReqDto memberReqDto) {
        return memberService.saveMember(memberReqDto);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", useReturnTypeSchema = true),
    })
    @Operation(summary = "회원 조회", description = "1~5까지 샘플 데이터로 조회됩니다.")
    @GetMapping("{id}")
    public MemberRspDto findMember(@PathVariable Long id) {
        return memberService.findMember(id);
    }

}
