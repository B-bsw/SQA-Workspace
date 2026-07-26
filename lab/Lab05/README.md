# How to run Testing
> TestShiftCipher

```bash
# both
mvn test -Dtest=TestShiftCipher
# Encrypt
mvn test -Dtest=TestShiftCipher#Encrypt
# Decrypt
mvn test -Dtest=TestShiftCipher#Decrypt
```

> TestCompetitionScore

```bash
# both
mvn test -Dtest=TestCompetitionScore
# testFindMaxScore3
mvn test -Dtest=TestCompetitionScore#testFindMaxScore3
# testFindMaxScoreArray
mvn test -Dtest=TestCompetitionScore#testFindMaxScoreArray
```
