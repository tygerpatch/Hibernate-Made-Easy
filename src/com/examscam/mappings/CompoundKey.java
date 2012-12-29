package com.examscam.mappings;

import java.io.Serializable;
import javax.persistence.Embeddable;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 294 CompoundKey class
// Page: 296 equals method
// Page: 298 hashCode method

@Embeddable
public class CompoundKey implements Serializable {

    public CompoundKey() {
    }

    public CompoundKey(Long user, Long bank) {
        userId = user;
        bankId = bank;
    }

    private Long bankId;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean equals(Object key){
        boolean result = true;
        if(!(key instanceof CompoundKey)) {
            return false;
        }
        Long otherUserId = ((CompoundKey)key).getUserId();
        Long otherBankId = ((CompoundKey)key).getBankId();
        if(bankId == null || otherBankId == null){
            result = false;
        }
        else {
            result = bankId.equals(otherBankId);
        }
        if(userId == null || otherUserId == null) {
            result = false;
        }
        else {
            result = userId.equals(otherUserId);
        }
        return result;
    }

    public int hashCode() {
        int code = 0;
        if(userId != null) {
            code += userId;
        }
        if(bankId != null) {
            code += bankId;
        }
        return code;
    }
}
