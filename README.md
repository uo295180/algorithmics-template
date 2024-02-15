# algorithmics-template
Template for algorithmics lab sessions

## Session 1.1

### Activity 1

Calculate how many more years we can continue using the way of counting:
Knowing that:
- *System.currentTimeMillis()* measures the time in a type long variable
- It measures the time from the first of January of 1970
- Long has **64 bits**
Using java, we can obtain the maximum date that the max value of long corresponds
to with:

```Java
long max = Long.MAX_VALUE;
Date d = new Date(max);
System.out.println(d); // Maximum date reachable -> Sun Aug 17 08:12:55 CET 292278994
System.out.println(d.year - 2024) // Years left -> 292275070
```

And we obtain:
***Sun Aug 17 08:12:55 CET 292278994***

Then, that's the maximum date, so from now we can just subtract 2024
Then we have ***292275070*** years left

### Activity 2:

- What does it mean that the time measured is 0?
	
	When the time measured is 0, it means that the execution time is so low that 
	we cant have any relevant measures of the algorithm. Then, we'll need to increase n in 
	order to get some relevant information 

-  From what size of problem (n) do we start to get reliable times?
	
	To get a reliable time, we need to obtain a time bigger than 50 ms. For example,
	for the n = 10000000, the algorithm wastes 83ms

### Activity 3:

- What happens with the time if the problem size is multiplied by 2? What happens with the time if the problem size is multiplied by a value k other than 2? (try it, for example, for k=3 and k=4 and check the times obtained)
	
	-> The time will increase in proportion to the factor applied to it, but it will still have the same complexity.

Explain whether the times obtained are those expected from the linear complexity O(n)



From what we saw in Vector4.java measuring the times for sum, create the following three java classes:
 - **Vector5.java** to measure times for **maximum**.
 - **Vector6.java** to measure times for **matches1**.
 - **Vector7.java** to measure times for **matches2**.

The data of this new classes measures are in the table below. Those measures for Tmatches1 are mostly Oot (Out of time), because they exceed 60 seconds. That happens because the algorithm used in this case has a O($n^{2}$) complexity, so its executions time grows heavily. It can be seen that the lowest time value for Tmatches1 is greater than the biggest one of Tsum.

|n|Tsum|Tmaximum|Tmatches1|Tmatches2|
|--|---|--------|--|--|
|**10000**|0.115 ms |0.119 ms |725 ms |0.142 ms |
|**20000**|0.282 ms |0.326 ms |3443 ms |0.312 ms |
|**40000**|0.53 ms |0.492 ms |11791 ms |0.627 ms |
|**80000**|1.07 ms |1.23 ms |44737 ms |1.12 ms |
|**160000**|2.14 ms |2.48 ms |187085 ms |2.23 ms |
|**320000**|4.28 ms |4.11 ms |Oot |3.7 ms |
|**640000**|8.6 ms |10.4 ms |Oot |10.1 ms |
|**1280000**|16.6 ms |21 ms |Oot |19 ms |
|**2560000**|32.3 ms |42.2 ms |Oot |26.3 ms |
|**5120000**|59 ms |83.7 ms |Oot |48.1 ms |
|**10240000**|93 ms |131.8 ms |Oot |135 ms |
|**20480000**|203 ms |241.1 ms |Oot |234 ms |
|**40960000**|267 ms |468 ms |Oot |438 ms |
|**81920000**|707 ms |916.4 ms |Oot |896 ms |


|nTimes|Time units|
|---|----|
|1|Milliseconds ($10^{-3}$ sg)|
|10|Tens of millisec ($10^{-4}$ sg)|
|100|Hundreds of millisec ($10^{-5}$ sg)|
|1000|Microseconds ($10^{-6}$ sg)|
|10000|Tends of micros ($10^{-6}$ sg)|
|10000|Hundreds of micros ($10^{-7}$ sg)|


## Session 1.2

Classes **Loop1.java, Loop2.java, Loop3.java and Loop4.java** are provided. Iterative models to determine their time complexity.

### 2. Some iterative models  

- **Loop1.java**
```Java
long cont = 0;
long n1 = 1;

while (n1 <= n * n) { // log3(n^2)
	for (long i = 1; i <= 2 * n; i += 3) // 2n/3
		cont++;
	n1 = 3 * n1;
}

// total complexity -> log3(n^2)*2n/3 -> O(nlog(n))

return cont;
```

- **Loop2.java**
```Java
long cont = 0;
long n1 = n;

do {
	for (long i = 1; i <= n; i++) // n
		for (long j = n; j >= 0; j -= 2) // n/2
			cont++;
	n1 = n1 / 3;
} while (n1 >= 1); // log3(n)

// total complexity -> log3(n)*n*n/2 -> O(n^2log(n))

return cont;
```

- **Loop3.java**
```Java
long cont = 0;
long i = 1;

while (i <= 2 * n) { // 2n
	for (long j = i; j >= 0; j -= 2) // 2n/2
		for (long k = 1; k <= n; k *= 2) // log2(n)
			cont++;
	i++;
}
// total complexity -> 2n*2n/2*log2(n) -> O(n^2log(n))

return cont;
```

- **Loop4.java**
```Java
long cont = 0;

for (int i = 1; i <= n; i++) // n
	for (int j = 1; j <= i; j++) // n
		for (int k = 1; k <= j; k++) // n
			cont++;

// total complexity -> n*n*n -> O(n^3)

return cont;
```


After the execution of the different algorithms, we can measure their times and observe that, in order, from loop 1 to loop 4 the time increases
|N|tLoop1|tLoop2|tLoop3|tLoop4|
|--|--|---|---|---|
|**100**|0.0099|0.367|1.27|1.24|
|**200**|0.0207|1.37|5.44|9.73|
|**400**|0.0452|6.39|26.85|78.51|
|**800**|0.123|28.3|113|638|
|**1600**|0.359|115|503|5244|
|**3200**|0.478|521|2168|37901|
|**6400**|1.02|2059|9142|Oot|
|**12800**|2.37|9216|36909|Oot|
|**25600**|4.83|41427|Oot|Oot|
|**51200**|10.13|Oot|Oot|Oot|

Knowing that: 
- **loop1** has O($n\log(n)$) complexity
- **loop2** has O($n^{2}\log(n)$) complexity
- **loop3** has O($n^{2}\log(n)$) complexity
- **loop4** has O($n^{3}$) complexity

We can observe that the increase of these algorithm thoretical complexities directly reflects into our time measurements


### 3. Creation of iterative models of a given time complexity

We're asked to create new **Loop5.java, Loop6.java and Loop7.java** clasess implementing new loops that satisfies the following thoretical time complexities:
- **loop5** has O($n^{2}\log^{2}(n)$) complexity
- **loop6** has O($n^{3}\log(n)$) complexity
- **loop7** has O($n^{4}$) complexity

The following implementations are my approach for the problem:

- **Loop5.java**
```Java
long cont = 0;
long n1 = n;

do {
	for (long i = 1; i <= n; i++) // n
		for (long j = n; j >= 0; j -= 2) // n/2
			for(long k = 1; k <= n; k *= 2) // log2(n)
				cont++;
	n1 = n1 / 2;
} while (n1 >= 1); // log2(n)

// total complexity -> log2(n)*log2(n)*n*n/2 -> O(n^2log^2(n))

return cont;
```

- **Loop6.java**
```Java
long cont = 0;
long n1 = n;

do {
	for (long i = 1; i <= n; i++) // n
		for (long j = n; j >= 0; j -= 2) // n/2
			for(long k = 0; k <= n; k++) // n
				cont++;
	n1 = n1 / 2;
} while (n1 >= 1); // log2(n)

// total complexity -> log2(n)*n*n*n/2 -> O(n^3log(n))

return cont;
```

- **Loop7.java**
```Java
long cont = 0;

for (int i = 1; i <= n; i++) // n
	for (int j = 1; j <= i; j++) // n
		for (int k = 1; k <= j; k++) // n
			for (int m = 1; m <= k; m++) // n
				cont++;

// total complexity -> n*n*n*n -> O(n^4)

return cont;
```


Then, the table of times that we obtain from the execution of this algorithims without optimizations is:

|N|tLoop5|tLoop6|tLoop7|
|--|--|---|---|
|**100**|5.6|51.1|40.2|
|**200**|30|482|552|
|**400**|109|3897|8323|
|**800**|513|34985|Oot|
|**1600**|3069|Oot|Oot|
|**3200**|12940|Oot|Oot|
|**6400**|57776|Oot|Oot|

In this case, as we increase the theoretical complexities of our algorithms, the time increases again as O($n^{2}\log^{2}(n)$) < O($n^{3}\log(n)$) < O($n^{4}$)

### 4. Comparison of two algorithms

