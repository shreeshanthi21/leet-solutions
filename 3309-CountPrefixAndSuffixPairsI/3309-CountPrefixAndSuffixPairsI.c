// Last updated: 5/26/2026, 12:30:20 PM
#include <string.h>
#include <stdbool.h>

bool isPrefixAndSuffix(const char* str1, const char* str2) {
    size_t len1 = strlen(str1);
    size_t len2 = strlen(str2);

    if (len1 > len2) {
        return false;
    }

    // Check prefix
    if (strncmp(str1, str2, len1) != 0) {
        return false;
    }

    // Check suffix
    if (strncmp(str1, str2 + (len2 - len1), len1) != 0) {
        return false;
    }

    return true;
}

int countPrefixSuffixPairs(char** words, int wordsSize) {
    int count = 0;
    for (int i = 0; i < wordsSize; i++) {
        for (int j = i + 1; j < wordsSize; j++) {
            if (isPrefixAndSuffix(words[i], words[j])) {
                count++;
            }
        }
    }
    return count;
}