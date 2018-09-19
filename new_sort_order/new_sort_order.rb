# https://app.codesignal.com/challenge/JyiFT8KJkRFXwAwd2

def is_valid?(str)
    return false if str.empty?  # empty id strings are not valid
    if str.include?('X')
        str =~ /^X(?![X])[a-z0-9]+X$/
    else
        str =~ /[a-z0-9]/   # lowercase letters and digits
    end
end

def normalize(str)
    return str unless str.include?('X')
    str[0] = str[-1]='' # remove the wrapping 'X' chars
    str.gsub(/[0-9]/, '')   # remove digits
end

# ---

def newSortOrder(docIDs)
    # step 1: remove invalid ids
    docIDs.select! { |str| is_valid?(str) }
    
    # step 2: normalize
    docIDs.map! { |str| normalize(str) }
    docIDs.reject!(&:empty?) # dirty hack workaround
    
    # step 3: split
    letter_ids, numeric_ids = docIDs.partition { |id| id =~ /^[a-z]/ }
    
    # step 4: sort
    letter_ids.sort!
    numeric_ids.sort! do |a,b| 
        a[0] == b[0] ? a <=> b : b <=> a
    end
    
    # output
    letter_ids+numeric_ids
end

