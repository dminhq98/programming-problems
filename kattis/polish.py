from sys import stdin

def is_operator(c):
    return (c in ('+', '-', '*'))

def is_variable(c):
    return (c in range('a', 'z'))

def is_constant(c):
    try:
        int(c)
        return True
    except:
        return False

case_n = 1
for line in stdin:
    s = []
    for c in line.rstrip().split(' '):
        s.append(c)
    change_made = True
    while len(s) >= 3 and change_made:
        change_made = False
        for i in xrange(len(s)-2):
            try:
                if is_operator(s[i]) and is_constant(s[i+1]) and is_constant(s[i+2]):
                    result = [eval("{} {} {}".format(s[i+1], s[i], s[i+2]))]
                    head = s[:i]
                    tail = s[i+3:] if i+3 < len(s) else []
                    s = head + result + tail
                    change_made = True
            except IndexError:
                break
    print 'Case {}: {}'.format(case_n, ' '.join(map(str, s)))
    case_n += 1

