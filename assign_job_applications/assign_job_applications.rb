# https://codefights.com/challenge/L4QW24zJS42QRbvoc

def assignJobApplications(tsm_count, available_locations, min_experience, job_applications)
    tsm_counter = 0
    locs = Hash[available_locations.map { |location| [location, 1] }]
    job_applications.map do |application|
        _, experience, location = application.split(' ')
        next -1 if experience.to_i < min_experience
        next -1 unless locs[location]
        (((tsm_counter+=1)-1) % tsm_count)+1
    end
end

