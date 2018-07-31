# https://app.codesignal.com/challenge/MfzDAFJj7awYyYEpK

// in-game simulation class/struct
// ---

var CALIBER_DMG = map[string]int { 
    "17mm": 50, 
    "42mm": 500, 
}

type Robot struct {
    HP int
    DamageTaken int
}

type Base struct {
    Team *RoboTeam  // child -> parent ref
    HP int
    DamageTaken int
}

type RoboTeam struct {
    Name string
    Robots []*Robot
    Base *Base
}

// ---

func (r *Robot) takeDamage(damage int) {
    r.HP -= damage  // decreate the health
    r.DamageTaken += damage
}

func (r *Robot) isDestroyed() bool {
    return r.HP <= 0
}

func (rt *RoboTeam) totalDamageTaken() int {
    var totalDamage int // zero
    
    for _,v := range rt.Robots {
        totalDamage += v.DamageTaken
    }
    
    return totalDamage + rt.Base.DamageTaken
}

func (rt *RoboTeam) atLeastOneRobotLost() bool {
    for _, robot := range rt.Robots {
        if robot.isDestroyed() {
            return true
        }
    }
    
    return false
}

func (b *Base) takeDamage(damage int) {
    if b.Team.atLeastOneRobotLost() {
        b.HP -= damage
        b.DamageTaken += damage
    }
}

// ---

// aux
func createTeam(name string, pool map[string]interface{}) RoboTeam {
    // helper function
    robotName := func(teamName string, num int) string {
        return teamName + " " + strconv.Itoa(num)
    }
    
    createRobot := func(hp int) Robot {
        return Robot { HP: hp }
    }
    
    base := Base { HP: 10000 }
    rt := RoboTeam { Name: name, Base: &base }   // name is not needed (just for fun)
    rt.Base.Team = &rt  // back-ref (child -> parent)
    botHPs := []int { 1000, 2000, 5000, 1000, 1000 }
    
    rt.Robots = make([]*Robot, 5)  // exactly 5 robots
    
    for i := range botHPs {
        bot := createRobot(botHPs[i])
        pool[robotName(name,i+1)] = &bot    // add to pool
        rt.Robots[i] = &bot
    }
    
    // add base
    pool[name + " base"] = &base
    return rt
}

// ---

// 1,4,5 - standard
// 2 - hero
// 3 - engineer
func roboMaster(shots [][]string) string {
    pool := make(map[string]interface{})
    
    // initialize the teams
    teamRed  := createTeam("red",  pool)
    teamBlue := createTeam("blue", pool)
    
    for _, shot := range shots {
        target := pool[shot[1]]
        dmg := CALIBER_DMG[shot[2]]
        
        // interface -> concrete type
        switch t := target.(type) {
            case *Base:
                t.takeDamage(dmg)
            case *Robot:
                t.takeDamage(dmg)
        }
    }
    
    if teamRed.Base.DamageTaken < teamBlue.Base.DamageTaken {
        return "red"
    } else if teamRed.Base.DamageTaken > teamBlue.Base.DamageTaken {
        return "blue"
    } else if teamRed.totalDamageTaken() < teamBlue.totalDamageTaken() {
        return "red"
    } else if teamRed.totalDamageTaken() > teamBlue.totalDamageTaken() {
        return "blue"
    } else {
        return "draw"
    }
}

