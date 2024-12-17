from datasets import load_dataset
from nltk.tokenize import TreebankWordTokenizer

ds = load_dataset("nbroad/basic_text_dataset")

train_ds = ds["train"]
val_ds = ds["validation"]

tokenizer = TreebankWordTokenizer()

output = []

def tokenize_text(text):
    for t in range(len(text)):
        output.append(tokenizer.tokenize(text[t]["text"]))

tokenize_text(val_ds)

# save the output to a file
with open("src/main/resources/pythonfiles/testdata.txt", "w") as f:
    for item in output:
        f.write("%s\n" % item)