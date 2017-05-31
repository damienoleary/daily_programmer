    import Data.List

    takeTwo :: [Int] -> [(Int, Int)]
    takeTwo [] = []
    takeTwo [_] = []
    takeTwo xs = (xs!!0, xs!!1):(takeTwo (tail xs))

    absDiffs :: [(Int, Int)] -> [Int]
    absDiffs xs = [abs (a - b) | (a, b) <- xs]

    uniq :: [Int] -> [Int]
    uniq [] = []
    uniq [x] = [x]
    uniq xs = if xs!!0 == xs!!1 then uniq (tail xs) else (head xs):(uniq (tail xs))


    isJolly:: [Int] -> Bool
    isJolly [] = False
    isJolly [_] = False
    isJolly xs = uniq (sort (absDiffs (takeTwo xs))) == [1..(length xs)-1]
