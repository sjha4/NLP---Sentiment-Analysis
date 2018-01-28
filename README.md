# Sentiment Analysis using __WEKA Machine Learning Library__

Uses N-gram models (uni, bi and tri) and ID3 algorithm to train decision trees that are able to detect the sentiment of a sentence.

## Dataset Used:
[UCI Dataset Archive](https://archive.ics.uci.edu/ml/datasets/Sentiment+Labelled+Sentences)

## Data Preprocessing:
* Combine the 3 data files into one.
* Converted to lower case and performed the inbuilt stop word handler from weka library.
Ignore Stop Words. (Rainbow handler1).
* Removed . , ! and ?
* Ran a script to separate Sentences of label 0 and 1.
* Created separate directories for 0 and 1 and got 1500 files each with labels 0 and 1.
* Used weka.core.converters.TextDirectoryLoader library to convert this directory
structure into arff format.


## Parameter Tuning:
1. Id3 tree takes nominal attributes and classes, therefore needed to convert that.
2. Converted the string sentences to word vector.
3. Applied tokenizing for getting n-gram tokens out of the sentences.
## Data Setup:
1. Randomized the tokenized input vector and selected 70% for training and
rest was for testing.
2. Changed class labels to “one” and “zero”
