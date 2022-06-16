package com.kag.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @apiNote 随机密码生成工具类
 * @author KHighness
 * @since 2020/5/8
 */
public class RandomPasswordGenerator {

    enum CharacterType {
        LOWERCASE,
        UPPERCASE,
        NUMBER,
        SPECIAL_CHARACTER
    }

    private static final char[] allowedSpecialCharactors = {
            '`', '~', '@', '#', '$', '%', '^', '&',
            '*', '(', ')', '-', '_', '=', '+', '[',
            '{', '}', ']', '\\', '|', ';', ':', '"',
            '\'', ',', '<', '.', '>', '/', '?'};//密码能包含的特殊字符
    private static final int letterRange = 26;
    private static final int numberRange = 10;
    private static final int spCharacterRange = allowedSpecialCharactors.length;
    private static final Random random = new Random();
    private int passwordLength;//密码的长度
    private int minVariousType;//密码包含字符的最少种类

    public RandomPasswordGenerator(int passwordLength, int minVariousType) {
        if (minVariousType > CharacterType.values().length) minVariousType = CharacterType.values().length;
        if (minVariousType > passwordLength) minVariousType = passwordLength;
        this.passwordLength = passwordLength;
        this.minVariousType = minVariousType;
    }

    public String getRandomPassword() {
        char[] password = new char[passwordLength];
        List<Integer> pwCharsIndex = new ArrayList();
        for (int i = 0; i < password.length; i++) {
            pwCharsIndex.add(i);
        }
        List<CharacterType> takeTypes = new ArrayList(Arrays.asList(CharacterType.values()));
        List<CharacterType> fixedTypes = Arrays.asList(CharacterType.values());
        int typeCount = 0;
        while (pwCharsIndex.size() > 0) {
            int pwIndex = pwCharsIndex.remove(random.nextInt(pwCharsIndex.size()));//随机填充一位密码
            Character c;
            if (typeCount < minVariousType) {//生成不同种类字符
                c = generateCharacter(takeTypes.remove(random.nextInt(takeTypes.size())));
                typeCount++;
            } else {//随机生成所有种类密码
                c = generateCharacter(fixedTypes.get(random.nextInt(fixedTypes.size())));
            }
            password[pwIndex] = c.charValue();
        }
        return String.valueOf(password);
    }

    private Character generateCharacter(CharacterType type) {
        Character c = null;
        int rand;
        switch (type) {
            case LOWERCASE://随机小写字母
                rand = random.nextInt(letterRange);
                rand += 97;
                c = new Character((char) rand);
                break;
            case UPPERCASE://随机大写字母
                rand = random.nextInt(letterRange);
                rand += 65;
                c = new Character((char) rand);
                break;
            case NUMBER://随机数字
                rand = random.nextInt(numberRange);
                rand += 48;
                c = new Character((char) rand);
                break;
            case SPECIAL_CHARACTER://随机特殊字符
                rand = random.nextInt(spCharacterRange);
                c = new Character(allowedSpecialCharactors[rand]);
                break;
        }
        return c;
    }

//    public static void main(String[] args) {
//        System.out.println(new RandomPasswordGenerator(10, 3).getRandomPassword());
//    }
}

