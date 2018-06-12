# https://codefights.com/challenge/C57Jdx9oyn4ibZgb8

require 'json'
require 'net/http'

def formulaOneBet(year, round, bets)
    # part 1: get the data
    url = 'http://ergast.com/api/f1/%s/%s/driverStandings.json' % [year,round]
    uri = URI(url)
    response = Net::HTTP.get(uri) # raw response
    json = JSON.parse(response)
    # drivers = json['MRData']['DriverTable']['Drivers']
    standings = json['MRData']['StandingsTable']['StandingsLists'][0]['DriverStandings']
    
    h = {} # results hashmap
    standings.each do |standing|
        driver_id = standing['Driver']['driverId']
        h[driver_id] = standing['position']
    end
    
    # end of part 1
    # ---
    # part 2: process the bets
    all_bets = bets.flatten(1) # get a flat list of bets
    total = all_bets.sum { |bet| bet[2].to_f } # sum of all the bets
    
    bets_won = all_bets.select { |bet| h[bet[0]] == bet[1] }
    bets_won_total = bets_won.sum { |bet| bet[2].to_f }
    
    # ---
    
    # all user bets are to be considered
    bets.map do |user_bets|
        # earned amount over all the user bets
        user_bets.sum do |bet|
            bet_amount = bet[2].to_f
            bet_win = 0
            bet_win = bet_amount / bets_won_total * total if h[bet[0]] == bet[1]
            bet_win-bet_amount # net profit
        end
    end.max
end
