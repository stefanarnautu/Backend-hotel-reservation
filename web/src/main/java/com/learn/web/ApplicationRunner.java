package com.learn.web;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.learn.service.ReservationService;
//import com.learn.service.collections.CollectionsService;
//import com.learn.service.integers.IntegerService;
//import com.learn.service.strings.StringService;

@Component
public class ApplicationRunner implements CommandLineRunner {

    /*private final IntegerService integerService;
    private final StringService stringService;
    private final ReservationService reservationService;
    private final CollectionsService collectionsService;

    @Autowired
    public ApplicationRunner(IntegerService integerService,
                            StringService stringService,
                            ReservationService reservationService,
                            CollectionsService collectionsService){
        this.integerService = integerService;
        this.stringService = stringService;
        this.reservationService = reservationService;
        this.collectionsService = collectionsService;
    }*/

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println(reservationService.getAll().toString());
        System.out.println(integerService.inPrime(7));
        System.out.println(integerService.factorialIterative(5));
        System.out.println(integerService.factorialRecursive(5));
        System.out.println(integerService.digitsSum(55555)+" "+ integerService.digitsSum(23));
        System.out.println("Palindrom");
        System.out.println(integerService.palindrom(12321));
        System.out.println(integerService.palindrom(123321));
        System.out.println(integerService.palindrom(1234312));
        System.out.println("Perfect number");
        System.out.println(integerService.calculateperfectNumber(8));
        System.out.println(integerService.calculateperfectNumber(496));
        System.out.println("Keplar");
        System.out.println(integerService.keprekarNumber(1113));
        integerService.AllcircularPrimeNumberTo1000000();
        System.out.println("Second largest number");
        System.out.println(integerService.secondLargestValue(new int[]{9,3,7,4,8,4,9}));
        System.out.println(integerService.secondLargestValue(new int[]{8,4,5,2,7}));
        System.out.println("Rotate the array");
        int[] r = integerService.rotateKPositions(new int[]{1,2,3,4,5}, 2);
        for(int i = 0; i<r.length;i++){
            System.out.println(r[i]);
        }
        System.out.println("Pairs:");
        System.out.println(integerService.getThePairsThatHasTheSum(new int[]{2,4,3,5,7,8,1}, 9));
    
        System.out.println("Works with Strings");*/

        /*System.out.println(stringService.reverseWordsOrder("Ana are mere"));
        System.out.println(stringService.checkIfPalindormIgnoreCasesAndSpacesAndPunctuation("A man, a plan, a canal/, Panama!"));
        System.out.println(stringService.findTheFirstLetterThatAppearOnce("swiss"));
        System.out.println(stringService.replaceConsecutiveRepeatingCharacters("abbbcdddddef"));
        System.out.println(stringService.checkParanteses("))))"));
        System.out.println(stringService.decodeString("rf2[abc]3[cd]ef"));
        System.out.println(stringService.smallestWindowContainAllCharacters("ADOBECODEBANC", "ABC"));
        System.out.println(stringService.getLongestPrefix(new String[]{"flowles", "flo", "flowght"}));*/
    

        /*System.out.println("Collections:");
        collectionsService.addElementsToList(3,6,2,5,76,3);*/
    }

}
