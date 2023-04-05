package leetcode.catalog;

import leetcode.*;

public enum CatalogEnum {

    ONE(1, Level.EASY, TwoSum.class),
    FIVE(5, Level.MEDIUM, Palindromic.class),
    ELE(11, Level.MEDIUM, ContainerWithMostWater.class),
    FT(15, Level.MEDIUM, ThreeSum.class),
    SET(17, Level.MEDIUM, PhoneNumber.class),
    ET(18, Level.MEDIUM, FourSum.class),
    NT(19, Level.MEDIUM, RemoveLinkListNode.class),
    TTY(20, Level.EASY, ValidParentheses.class),
    TT(22, Level.MEDIUM, GenerateParentheses.class),
    TF(24, Level.MEDIUM, SwapNode.class),
    TS(27, Level.EASY, RemoveElement.class),
    TE(28, Level.EASY, OccurString.class),

    TH(34, Level.MEDIUM, FirstLastPositionArray.class),
    FO(41, Level.HARD, FirstMissingPositive.class),
    FF(45, Level.MEDIUM, JumpGameII.class),

    OZO(101, Level.EASY, SymmetricTree.class),

    OZF(104, Level.EASY, TreeMaxDepth.class),
    TTT(222, Level.MEDIUM, CompleteTreeNode.class),
    TTS(226, Level.EASY, InvertReverseTree.class),
    SZF(704, Level.EASY, BinarySearch.class),

    // other
    HYTECH(-1, Level.ALL, InterviewTest.class),
    TREND(-1, Level.ALL, TrendOne.class),

    ;

    private int id;
    private Level level;
    private Class cla;

    CatalogEnum(int i, Level l, Class c) {
    }

    static enum Level {
        EASY, MEDIUM, HARD, ALL
    }
}
