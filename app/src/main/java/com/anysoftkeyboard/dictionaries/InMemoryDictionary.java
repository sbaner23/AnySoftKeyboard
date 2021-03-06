package com.anysoftkeyboard.dictionaries;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;

import java.util.Collection;

public class InMemoryDictionary extends BTreeDictionary {

    private final Collection<String> mWords;

    public InMemoryDictionary(String dictionaryName, Context context, Collection<String> words, boolean includeTypedWord) {
        super(dictionaryName, context, includeTypedWord);
        mWords = words;
    }

    @Override
    protected void readWordsFromActualStorage(WordReadListener wordReadListener) {
        for (String word : mWords) {
            if (!wordReadListener.onWordRead(word, word.length()/*longer tags are more descriptive*/)) break;
        }
    }

    @Override
    protected void deleteWordFromStorage(String word) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void registerObserver(ContentObserver dictionaryContentObserver, ContentResolver contentResolver) {

    }

    @Override
    protected void addWordToStorage(String word, int frequency) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void closeStorage() {
    }
}
