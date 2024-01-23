package com.example.samplespringboot2javagradle.entity;

import org.springframework.data.repository.CrudRepository;

/**
 * <p>Member Repository
 *
 * @author dongyoung.kim
 * @since 1.0
 */
public interface MemberRepository extends CrudRepository<Member, Long> {

}
