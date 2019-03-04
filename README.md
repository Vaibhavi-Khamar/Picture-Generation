# Picture-Generation using Genetic Algorithm
Team members: 

Vaibhavi Khamar (001400149)
Qixiang Zhou (001822974)
Zhouwei Wang (001443886)

We used maven and junit4 in the project, please check when you run the project
All description about our idea, design, and experiment output is in Powerpoint file.

Problem description:
Use genetic algorithm to do the picture generation. Use components (Genes) to consist a picture (Individual, presented by 2D-Array). Store all pictures in a Priority Queue (Population), and let the fittest serval picture survive.

We have three approaches.
* First approach: Picture is presented as (0, 1) 2D-Array. Break down the target image to create Gene pool. Use those genes to create a valid image. 
* Second approach: Picture is presented as (0, 1) 2D-Array. Use random line (Gene) to generate image, the experiment is like drawing a picture using a pencil.
* Third approach: Pictures are presented by RGB value. Use random circle (Gene) to generate image.

What is genetic Algorithm?
In computer science and operations research, a genetic algorithm (GA) is a metaheuristic inspired by the process of natural selection that belongs to the larger class of evolutionary algorithms (EA). Genetic algorithms are commonly used to generate high-quality solutions to optimization and search problems by relying on bio-inspired operators such as mutation, crossover and selection. John Holland introduced Genetic Algorithm (GA) in 1960 based on the concept of Darwin’s theory of evolution; afterwards, his student Goldberg extended GA in 1989. -- quote from Wikipedia

Others:
For more details, please see our open-sources code, unit test pdf, also our PPT file !!!
