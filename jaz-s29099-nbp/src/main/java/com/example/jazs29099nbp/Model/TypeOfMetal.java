package com.example.jazs29099nbp.Model;

public enum TypeOfMetal {
    gold;

    public String getUrlName() {
        if (this == gold) {
            return "cenyzlota";
        }
        return null;
    }
}
