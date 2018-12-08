# https://app.codesignal.com/challenge/Ku7FEBSAmq4Av87uq

# if this works ... I'm the happiest person on the planet :D

import re
r = re.compile(r"(.+) \((\S+)\)")

# content <-> enjoyability mapping
d = {'G':10,'N':5,'W':3,'T':1,'B':-2,'A':-25 }

# extract the time string and enjoyability
def parse_program(s):
    m = r.match(s)
    v = m.groups()
    e = d[v[0][0]] # by the first character
    return (e,v[1])

# convert time string to seconds
def to_seconds(s):
    g = [int(i) for i in s.split(':')] # extract components
    return (g[0]*3600)+(g[1]*60)+g[2]

# unroll into seconds timeline as the first step
# each radio station - individual timeline
# => timetable, where row = station, column = time
# 
#  greedy solution possible? need to re-read the description 
def optimalRadioListening(schedules, commute_hours):
    num_stations = len(schedules) # number of radio stations available
    
    # get min/max estimates
    min_time = max_time = -1
    for station in schedules:
        for program in station:
            _, program_time = parse_program(program)
            if min_time == -1 or program_time < min_time:
                min_time = program_time
            
            if max_time == -1 or program_time > max_time:
                max_time = program_time
            
    
    # ---
    
    # commute time(s)
    commute_start_time, commute_end_time = [to_seconds(i) for i in commute_hours.split(' - ')]
    commute_time = commute_end_time - commute_start_time # total len
        
    table = [[0 for _ in range(commute_time)] for _ in range(num_stations)]
    for i in range(num_stations): # for every station
        num_of_programs = len(schedules[i]) # at least one program
        for pi in range(num_of_programs): # for every program on the station (program index)
            program_enjoyment, program_start_time = parse_program(schedules[i][pi])
            program_start_time = max(to_seconds(program_start_time), commute_start_time) # clip (left bound)
    
            if program_start_time > commute_end_time:
                break
    
            if pi < num_of_programs-1:
                _,next_program_time = parse_program(schedules[i][pi+1])
                program_end_time = to_seconds(next_program_time)
            else:
                program_end_time = commute_end_time
            
            # clip right
            program_end_time = min(program_end_time, commute_end_time)
            
            for t in range(program_start_time,program_end_time): # -1 second
                idx = t-commute_start_time # offset
                table[i][idx] = program_enjoyment
    
    # ---
    
    total_enjoyment = 0
    for t in range(commute_time):
        # for every second, find the most enjoyable content from all the stations
        # t = index
        
        vals = [table[s][t] for s in range(num_stations)]
        total_enjoyment += max(vals)
    
    return total_enjoyment
