package com.alex.d3_collection_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    // 牌面（3、4、10、J、Q、K、A、2，大小王时为空）
    private String rank;
    // 花色（♠、♥、♦、♣）或大小王标识（小王、大王）
    private String suit;

    private  int size;

    // 优化toString：大小王直接显示suit，常规牌显示“rank+suit”
    @Override
    public String toString() {
        return rank == null || rank.isEmpty() ? suit : rank + suit;
    }
}