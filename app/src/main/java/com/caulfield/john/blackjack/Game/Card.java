package com.caulfield.john.blackjack.Game;

import com.caulfield.john.blackjack.R;

import java.util.HashMap;

public class Card {
    public static final String CLUBS = "c";
    public static final String DIAMONDS = "d";
    public static final String HEARTS = "h";
    public static final String SPADES = "s";
    private static final int ACE   = 1;
    private static final int JACK  = 11;
    private static final int QUEEN = 12;
    private static final int KING  = 13;

    public static final HashMap<String, Integer> cardToImageMap = new HashMap<String, Integer>() {{
        // clubs
        put("1c", R.drawable.card_ac);
        put("2c", R.drawable.card_2c);
        put("3c", R.drawable.card_3c);
        put("4c", R.drawable.card_4c);
        put("5c", R.drawable.card_5c);
        put("6c", R.drawable.card_6c);
        put("7c", R.drawable.card_7c);
        put("8c", R.drawable.card_8c);
        put("9c", R.drawable.card_9c);
        put("10c", R.drawable.card_10c);
        put("11c", R.drawable.card_jc);
        put("12c", R.drawable.card_qc);
        put("13c", R.drawable.card_kc);

        // diamonds
        put("1d", R.drawable.card_ad);
        put("2d", R.drawable.card_2d);
        put("3d", R.drawable.card_3d);
        put("4d", R.drawable.card_4d);
        put("5d", R.drawable.card_5d);
        put("6d", R.drawable.card_6d);
        put("7d", R.drawable.card_7d);
        put("8d", R.drawable.card_8d);
        put("9d", R.drawable.card_9d);
        put("10d", R.drawable.card_10d);
        put("11d", R.drawable.card_jd);
        put("12d", R.drawable.card_qd);
        put("13d", R.drawable.card_kd);

        // hearts
        put("1h", R.drawable.card_ah);
        put("2h", R.drawable.card_2h);
        put("3h", R.drawable.card_3h);
        put("4h", R.drawable.card_4h);
        put("5h", R.drawable.card_5h);
        put("6h", R.drawable.card_6h);
        put("7h", R.drawable.card_7h);
        put("8h", R.drawable.card_8h);
        put("9h", R.drawable.card_9h);
        put("10h", R.drawable.card_10h);
        put("11h", R.drawable.card_jh);
        put("12h", R.drawable.card_qh);
        put("13h", R.drawable.card_kh);

        // spades
        put("1s", R.drawable.card_as);
        put("2s", R.drawable.card_2s);
        put("3s", R.drawable.card_3s);
        put("4s", R.drawable.card_4s);
        put("5s", R.drawable.card_5s);
        put("6s", R.drawable.card_6s);
        put("7s", R.drawable.card_7s);
        put("8s", R.drawable.card_8s);
        put("9s", R.drawable.card_9s);
        put("10s", R.drawable.card_10s);
        put("11s", R.drawable.card_js);
        put("12s", R.drawable.card_qs);
        put("13s", R.drawable.card_ks);
    }};

    private int val;
    private String suit;

    public Card(int val, String suit) {
        this.suit = suit;
        this.val = val;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getImageId() {
        String cardStr = val + suit;
        if (cardToImageMap.containsKey(cardStr))
            return cardToImageMap.get(cardStr);
        else
            return 0; // 0 is an invalid android resource id
    }
}
