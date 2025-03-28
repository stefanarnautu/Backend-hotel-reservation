package com.learn.service.integers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;


@Service
public class IntegerService {
    public boolean inPrime(int number){
        if(number<=1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    public int factorialIterative(int number){
        int result = 1;
        for(int i = 2;i<=number;i++){
            result*=i;
        }
        return result;
    }

    public int factorialRecursive(int number){
        if(number<=1){
            return 1;
        }else{
            return number * factorialRecursive(number-1);
        }
    }

    public int digitsSum(int number){
        int sum=0;
        while(number>0){
            sum+=number%10;
            number=number/10;
        }
        return sum;
    }

    public boolean palindrom(int number){
        int numberLength = String.valueOf(Math.abs(number)).length();
        for(int i=1;i<=numberLength/2;i++){
            int left = (int) (number/(Math.pow(10,numberLength-i))%10);
            int right = (int) (number%(Math.pow(10,i))/(Math.pow(10, i-1)));
            if(left != right){
                return false;
            }
        }
        return true;
    }

    public boolean calculateperfectNumber(int number){
        int result = 0;
        for(int i=1;i<=number/2;i++){
            if(number%i == 0){
                result+=i;
            }
        }
        return (result == number && number>0)? true : false;
    }

    public int keprekarNumber(int number){
        if(String.valueOf(number).length()!=4){
            return 0;
        }
        int count = 0;
        while (number!=6174) {
            int ascendentNumber = ascendentNumberDigitsOf(number);
            int descendentNumber = descendentNumberDigitsOf(number);
            number = descendentNumber - ascendentNumber;
            count++;
        }

        return count;
    }

    public int ascendentNumberDigitsOf(int number){
        int[] frequency = getFrequency(number);
        int result=0;
        for(int i=0;i<10;i++){
            while(frequency[i]!=0){
                result = result*10 + i;
                frequency[i]-=1;
            }
        }

        return result;
    }

    public int descendentNumberDigitsOf(int number){
        int[] frequency = getFrequency(number);
        int result=0;
        for(int i=9;i>=0;i--){
            while(frequency[i]!=0){
                result = result*10 + i;
                frequency[i]-=1;
            }
        }

        return result;
    }

    private int[] getFrequency(int number) {
        int[] frequency = new int[10];
        while(number>0){
            frequency[number%10]++;
            number = number/10;
        }
        return frequency;
    }

    public void AllcircularPrimeNumberTo1000000(){
        System.out.println("All circular prime numbers to 1.000.000:");
        for(int i=2;i<=1_000;i++){
            if(this.inPrime(i)){
                String stringValueOfTheNumber = String.valueOf(i);
                boolean isCirculaprPrime = true;
                for(int j=1;j<String.valueOf(i).length();j++){
                    int rotation = Integer.parseInt(stringValueOfTheNumber.substring(j) + stringValueOfTheNumber.substring(0,j));
                    if(!this.inPrime(rotation)){
                        isCirculaprPrime = false;
                        break;
                    }
                }
                if(isCirculaprPrime) System.out.println("This is one:" + i);
            }
        }
    }

    public int secondLargestValue(int[] numbers){
        if(numbers.length<2){
            return 0;
        }

        int maxValue = numbers[0];
        int secondMaxValue = Integer.MIN_VALUE;

        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>maxValue){
                secondMaxValue = maxValue;
                maxValue=numbers[i];
            }else if(numbers[i]<maxValue && numbers[i]>secondMaxValue){
                secondMaxValue = numbers[i];
            }
        }
        return secondMaxValue;
    }

    public int[] rotateKPositions(int[] array, int k){
        int[] result = new int[array.length];
        for(int i=k;i<array.length;i++){
            result[i-k] = array[i];
        }
        for(int i=0;i<k;i++){
            result[array.length-k+i] = array[i];
        }
        return result;
    }

    public List<Pair<Integer,Integer>> getThePairsThatHasTheSum(int[] numbers, int TargetSum){
        List<Pair<Integer,Integer>> result = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j] == TargetSum){
                    Pair<Integer,Integer> newPair = Pair.of(numbers[i],numbers[j]);
                    result.add(newPair);
                }
            }
        }
        return result;
    }


}
