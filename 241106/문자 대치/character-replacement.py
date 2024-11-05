def solution(x):
    if '.' in x: 
        if 'X' in x: sep_point_list_len = list(map(len, x.split('.')))
        else: return -1
    else: sep_point_list_len = [len(x)]
    return_list = []
    for l in sep_point_list_len:
        if l % 2 == 1: return -1
        else:
            if l % 4 == 0: return_list.append("a"*4*(l//4))
            elif l % 4 == 2: return_list.append("a"*4*(l//4) + "b"*2)
    return ''.join(return_list)

print(solution(input()))