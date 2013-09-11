1) Do NOT build the transformation graph in advance. Instead, calculate the adjacent words on the fly.
2) Don't use hash map to mark the words visting status. The dictionary is huge and the constant factor of 
looking up a hash map can not be ignored. Use a visited set is preferable.
