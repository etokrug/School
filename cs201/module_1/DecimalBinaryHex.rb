=begin
# Created:      10/4/2015
# Creator:      William Brown
# Purpose:      Quick way to memorize Decimal, Binary, and Hex forms"
# Notes:        I'm aware this is jumbled crap code - it was just to 
#               work something out quickly for one of my classes
#
=end
def memorize
    dbhArray = [
        ['0', '0000', '0'],
        ['1', '0001', '1'],
        ['2','0010','2'],
        ['3','0011','3'],
        ['4','0100','4'],
        ['5','0101','5'],
        ['6','0110','6'],
        ['7','0111','7'],
        ['8','1000','8'],
        ['9','1001','9'],
        ['10','1010','A'],
        ['11','1011','B'],
        ['12','1100','C'],
        ['13','1101','D'],
        ['14','1110','E'],
        ['15','1111','F'],
    ]

    namesArray = ['Decimal', 'Binary', 'Hex']

   arrRand = dbhArray[rand(15)]
   fromRand = rand(3)
   toRand = rand(3)


   while toRand == fromRand do
       toRand = rand(3)
   end
   
   puts "Please convert the #{namesArray[fromRand]}: #{arrRand[fromRand]} to #{namesArray[toRand]} format: "
   userInput = gets.chomp

   if userInput == arrRand[toRand] then
       puts "That is correct! #{namesArray[fromRand]}: #{arrRand[fromRand]} is equivalent to the #{namesArray[toRand]}: #{arrRand[toRand]}."
       #namesArray and arrRand must have the same length here!!!!
       for i in 0...arrRand.length
           puts "#{namesArray[i]}: #{arrRand[i]}"
       end
       return true
   else
       puts "#{userInput} is not correct. The correct values are: "
       for i in 0...arrRand.length
           puts "#{namesArray[i]}: #{arrRand[i]}"
       end
       return false
   end
end

active = true
print "Would you like to memorize some numbers? [Y/n] "
userInput = gets.chomp.downcase

while active do
    if userInput == 'y' then
        active = memorize
    else
        puts "Invalid input: #{userInput}!"
        puts "Exiting..."
    end
end



