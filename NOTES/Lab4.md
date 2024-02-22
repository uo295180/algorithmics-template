

# Activity 1 \[Direct exchange or Bubble algorithm]

Using **Vector.java** class, we can create an irdered vector, a vector in reverse order, and a randomize vector.
The **Bubble.java** class implements the bubble sort algorithm needed for sort this vector. 
Finally with the **BubbleTimes.java** we can increase the size of the problem and the times that it's executed.

|n|t ordered|t reverse|t random|
|--|--|--|--|
|10000|627|1942|1422|
|2\*10000|2544|7986|5827|
|$2^{2}$ \*10000|9827|31729|23609|
|$2^{3}$ \*10000|41002|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{4}$\*10000|<font color="red">Oot</font>|<font color="red">Oot</font>|<font color="red">Oot</font>|

The times obtained matches whith what was expected because the Bubble sort algorithm has a time complexity of O($n^{2}$)


# Activity 2 \[Selection algorithm]

|n|t ordered|t reverse|t random|
|--|--|--|--|
|10000|475|538|663|
|2\*10000|1994|3146|2102|
|$2^{2}$ \*10000|8403|9302|9675|
|$2^{3}$ \*10000|35484|38448|36442|
|$2^{4}$\*10000|<font color="red">Oot</font>|<font color="red">Oot</font>|<font color="red">Oot</font>|

It can be seen that, althoug the complexity is the same as in the Bubble algorithm, the Selection algorithm works better for unordered vectors than the bubble one

# Activity 3 \[Insertion algorithm]

|n|t ordered|t reverse|t random|
|--|--|--|--|
|10000|<font color="red">LoR</font>|1167|382|
|2\*10000|<font color="red">LoR</font>|3862|1584|
|$2^{2}$ \*10000|<font color="red">LoR</font>|13083|6008|
|$2^{3}$ \*10000|<font color="red">LoR</font>|54204|25926|
|$2^{4}$\*10000|<font color="red">LoR</font>|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{5}$ \*10000|<font color="red">LoR</font>|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{6}$ \*10000|<font color="red">LoR</font>|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{7}$\*10000|<font color="red">LoR</font>|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{8}$ \*10000|80|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{9}$ \*10000|120|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{10}$\*10000|236|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{11}$ \*10000|468|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{12}$ \*10000|936|<font color="red">Oot</font>|<font color="red">Oot</font>|
|$2^{13}$\*10000|1883|<font color="red">Oot</font>|<font color="red">Oot</font>|



# Activity 4 \[Quicksort algorithm]

|n|t ordered|t reverse|t random|
|--|--|--|--|
|10000|<font color="red">LoR</font>|<font color="red">LoR</font>|<font color="red">LoR</font>|
|2\*10000|<font color="red">LoR</font>|<font color="red">LoR</font>|<font color="red">LoR</font>|
|$2^{2}$ \*10000|<font color="red">LoR</font>|<font color="red">LoR</font>|<font color="red">LoR</font>|
|$2^{3}$ \*10000|<font color="red">LoR</font>|<font color="red">LoR</font>|<font color="red">LoR</font>|
|$2^{4}$\*10000|<font color="red">LoR</font>|59|88|
|$2^{5}$ \*10000|74|92|155|
|$2^{6}$ \*10000|389|162|332|
|$2^{7}$\*10000|317|332|727|
|$2^{8}$ \*10000|665|703|1604|
|$2^{9}$ \*10000|1441|1441|3607|
|$2^{10}$\*10000|2789|3478|9890|
|$2^{11}$ \*10000|6498|6145|26708|
|$2^{12}$ \*10000|13294|15441|<font color="red">Oot</font>|
|$2^{13}$\*10000|26242|28809|<font color="red">Oot</font>|


# Activity 5 \[Quicksort + Insertion algorithm]

|n|t random|
|--|--|
|Quicksort|18373|
|Quicksort + Insertion (k=5)|17680|
|Quicksort + Insertion (k=10)|16984|
|Quicksort + Insertion (k=20)|17500|
|Quicksort + Insertion (k=30)|19497|
|Quicksort + Insertion (k=40)|19235|
|Quicksort + Insertion (k=50)|22222|
|Quicksort + Insertion (k=100)|18297|
|Quicksort + Insertion (k=200)|12947|
|Quicksort + Insertion (k=500)|22225|
|Quicksort + Insertion (k=1000)|39794|
