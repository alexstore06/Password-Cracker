using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;

namespace PassCrack
{
    class Program
    {
        static void Main(string[] args)
        {
            string lowercase;
            string uppercase;
            string numbers;
            string special;
            string input;
            string[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "[", "]", "{", "}", "\\", "|", ";", ":", "'", "\"", ",", "<", ".", ">", "/", "?", " " };
            List<String> charset = new List<string>();
            Console.WriteLine("Welcome to my program!\nThis program takes an input string and a character set, and uses that character set to build guesses, which it then checks against the input string.\nPlease, start small! It can take many many guesses to guess the string, and the time it takes to crack the input increases exponentially with the\nlength of the input, even though you can expect anywhere from 1K to 10M guesses per second.");
            while(true)
            {
                Console.WriteLine("Lowercase characters? (y/n)");
                lowercase = Console.ReadLine();
                if (lowercase.Equals("y"))
                {
                    for (int i = 0; i < 26; i++)
                    {
                        charset.Add(alphabet[i]);
                    }
                    break;
                }
                else if (lowercase.Equals("n"))
                {
                    break;
                }
                else
                {
                    Console.WriteLine("Please enter valid input.");
                }
            }
            while (true)
            {
                Console.WriteLine("Uppercase characters? (y/n)");
                uppercase = Console.ReadLine();
                if (uppercase.Equals("y"))
                {
                    for (int i = 26; i < 52; i++)
                    {
                        charset.Add(alphabet[i]);
                    }
                    break;
                }
                else if (uppercase.Equals("n"))
                {
                    break;
                }
                else
                {
                    Console.WriteLine("Please enter valid input.");
                }
            }
            while (true)
            {
                Console.WriteLine("Numbers? (y/n)");
                numbers = Console.ReadLine();
                if (numbers.Equals("y"))
                {
                    for (int i = 52; i < 62; i++)
                    {
                        charset.Add(alphabet[i]);
                    }
                    break;
                }
                else if (numbers.Equals("n"))
                {
                    break;
                }
                else
                {
                    Console.WriteLine("Please enter valid input.");
                }
            }
            while (true)
            {
                Console.WriteLine("Special characters? (y/n)");
                special = Console.ReadLine();
                if (lowercase.Equals("y"))
                {
                    for (int i = 62; i < alphabet.Length; i++)
                    {
                        charset.Add(alphabet[i]);
                    }
                    break;
                }
                else if (special.Equals("n"))
                {
                    break;
                }
                else
                {
                    Console.WriteLine("Please enter valid input.");
                }
            }
            while (true)
            {
                Console.WriteLine("Input string:");
                input = Console.ReadLine();
                if (input.Equals(""))
                {
                    Console.WriteLine("Please do not leave input blank.");
                }
                else
                {
                    break;
                }
            }
            String foundword = "";
            Random r = new Random();
            int rand;
            long j = 0;
            Stopwatch c = new Stopwatch();
            double tTotal;
            c.Start();
            long per;
            double keyspace;
            while(true)
            {
                for(int i = 0; i<input.Length; i++)
                {
                    rand = r.Next(charset.Count);
                    foundword += charset[rand];
                }
                if(foundword.Equals(input))
                {
                    c.Stop();
                    tTotal = c.ElapsedMilliseconds/1000;
                    j++;
                    per = (long)(j / tTotal);
                    keyspace = (j / Math.Pow(charset.Count, input.Length)) * 100;
                    Console.WriteLine("Found input after " + j + " iterations, over " + tTotal + " seconds, (" + per + " iterations/sec) using " + keyspace + "% of the keyspace.");
                    break;
                }
                else
                {
                    j++;
                    foundword = "";
                }
            }
            Console.WriteLine("Press any key to quit . . . ");
            Console.ReadKey();
        }
    }
}
