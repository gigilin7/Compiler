## 編譯器(Compiler)
+ Scanner
  - 把字元合併成為詞語<br>
`
Characters ---> Tokens
`
+ Parser
  - 把詞語組合成一句有意思的句子<br>
`
Tokens ---> Sentences
`

## Parser實作
+ Recursive-decent LL(1) parser：Chap2及Chap5範例CFG
+ Table-driven LL(1) parser：直接輸入CFG
  - First
  - Follow

## 成果(以下使用Chap5範例CFG)
+ First

<img src="https://raw.githubusercontent.com/gigilin7/Compiler/main/picture/FIRST.jpg" height=400>

+ Recursive-decent LL(1) parser

<img src="https://raw.githubusercontent.com/gigilin7/Compiler/main/picture/RD5.jpg" height=200>

+ Table-driven LL(1) parser

<img src="https://raw.githubusercontent.com/gigilin7/Compiler/main/picture/TD.jpg" height=400>
