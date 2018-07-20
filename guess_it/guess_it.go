# https://app.codesignal.com/challenge/vCcqqvqBYM8k2dHhE

import (
    "strings"
    "regexp"
)

var dollarReplacerRegexp = regexp.MustCompile(`\${2,}`)
var replacer = strings.NewReplacer("$", "(?:.*)")

func guessIt(message string, options []string) []string {
    msgFormatted := dollarReplacerRegexp.ReplaceAllString(message, "$")
    msgRegexpStr := "^"+replacer.Replace(msgFormatted)
    msgRegexp := regexp.MustCompile(msgRegexpStr)
    
    matchedOptions := make([]string, 0)
    for _, option := range options {
        if msgRegexp.MatchString(option) {
            matchedOptions = append(matchedOptions, option)
        }
    }
    
    
    return matchedOptions
}

